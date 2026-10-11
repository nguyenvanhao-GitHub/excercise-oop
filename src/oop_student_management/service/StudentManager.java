package oop_student_management.service;

import oop_student_management.entity.GoodStudent;
import oop_student_management.entity.NormalStudent;
import oop_student_management.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManager {
    private final List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student != null) {
            this.students.add(student);
        }
    }

    public List<Student> getStudents() {
        return this.students;
    }

    // Yêu cầu 3: Sắp xếp sinh viên khá giỏi
    // Ưu tiên theo điểm GPA giảm dần. Nếu trùng GPA -> họ tên tăng dần (A-Z).
    public List<GoodStudent> getSortedGoodStudents(List<GoodStudent> goodStudents) {
        return goodStudents.stream()
                .sorted(Comparator.comparing(GoodStudent::getGpa).reversed()
                        .thenComparing(GoodStudent::getFullName))
                .collect(Collectors.toList());
    }

    // Yêu cầu 3: Sắp xếp sinh viên trung bình
    // Ưu tiên điểm thi chuyên môn (entryTestScore) giảm dần -> điểm TOEIC (englishScore) giảm dần -> họ tên tăng dần (A-Z).
    public List<NormalStudent> getSortedNormalStudents(List<NormalStudent> normalStudents) {
        return normalStudents.stream()
                .sorted(Comparator.comparing(NormalStudent::getEntryTestScore).reversed()
                        .thenComparing(Comparator.comparing(NormalStudent::getEnglishScore).reversed())
                        .thenComparing(NormalStudent::getFullName))
                .collect(Collectors.toList());
    }

    // Yêu cầu 3: Chức năng tuyển sinh viên vào công ty (11 - 15 ứng viên)
    public List<Student> recruitCandidates(int numberNeeded) {
        if (numberNeeded < 11 || numberNeeded > 15) {
            throw new IllegalArgumentException("Số lượng ứng viên cần tuyển phải từ 11 đến 15 người!");
        }

        List<GoodStudent> goodStudents = new ArrayList<>();
        List<NormalStudent> normalStudents = new ArrayList<>();

        for (Student s : students) {
            if (s instanceof GoodStudent gs) {
                goodStudents.add(gs);
            } else if (s instanceof NormalStudent ns) {
                normalStudents.add(ns);
            }
        }

        List<GoodStudent> sortedGood = getSortedGoodStudents(goodStudents);
        List<NormalStudent> sortedNormal = getSortedNormalStudents(normalStudents);

        List<Student> selected = new ArrayList<>();

        if (sortedGood.size() > numberNeeded) {
            selected.addAll(sortedGood.subList(0, numberNeeded));
        } else {
            selected.addAll(sortedGood);
            int remaining = numberNeeded - selected.size();
            if (remaining > 0) {
                int countToTake = Math.min(remaining, sortedNormal.size());
                selected.addAll(sortedNormal.subList(0, countToTake));
            }
        }

        return selected;
    }

    // Yêu cầu 4: Hiển thị danh sách sinh viên sắp xếp giảm dần theo fullName và tăng dần theo phoneNumber
    public void displayAllSortedByNameAndPhone() {
        if (students.isEmpty()) {
            System.out.println("Danh sách sinh viên hiện đang trống.");
            return;
        }

        List<Student> sortedList = new ArrayList<>(students);

        // Dùng Collections.sort: fullName giảm dần (reversed), phoneNumber tăng dần
        Collections.sort(sortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int nameCompare = s2.getFullName().compareTo(s1.getFullName()); // Giảm dần
                if (nameCompare != 0) {
                    return nameCompare;
                }
                return s1.getPhoneNumber().compareTo(s2.getPhoneNumber()); // Tăng dần
            }
        });

        System.out.println("==========================================================================");
        System.out.println(" DANH SÁCH SINH VIÊN (SẮP XẾP: TÊN GIẢM DẦN, SĐT TĂNG DẦN)");
        System.out.println("==========================================================================");
        for (int i = 0; i < sortedList.size(); i++) {
            Student s = sortedList.get(i);
            System.out.println((i + 1) + ". Họ tên: " + s.getFullName() +
                    " | SĐT: " + s.getPhoneNumber() +
                    " | Loại: " + (s instanceof GoodStudent ? "Khá/Giỏi" : "Trung bình") +
                    " | Ngày sinh: " + s.getDoB() +
                    " | Trường: " + s.getUniversityName());
        }
    }
}
