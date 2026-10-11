package oop_managing_academic_results;

import java.util.*;

public class Department {
    private String departmentName;
    private List<Student> students;

    // 1. Constructor chuẩn (default)
    public Department() {
        this.departmentName = "Khoa CNTT";
        this.students = new ArrayList<>();
    }

    // 2. Constructor có tham số
    public Department(String departmentName) {
        setDepartmentName(departmentName);
        this.students = new ArrayList<>();
    }

    // 3. Constructor sao chép (copy constructor)
    public Department(Department other) {
        if (other != null) {
            this.departmentName = other.departmentName;
            this.students = new ArrayList<>();
            for (Student s : other.students) {
                if (s instanceof RegularStudent reg) {
                    this.students.add(new RegularStudent(reg));
                } else if (s instanceof InServiceStudent ins) {
                    this.students.add(new InServiceStudent(ins));
                } else {
                    this.students.add(new Student(s));
                }
            }
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên khoa không được để trống!");
        }
        this.departmentName = departmentName.trim();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students != null ? students : new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student != null) {
            this.students.add(student);
        }
    }

    // Yêu cầu 8: Phương thức xác định tổng số sinh viên chính quy của khoa
    public int getTotalRegularStudents() {
        int count = 0;
        for (Student s : students) {
            if (s.isRegularStudent()) {
                count++;
            }
        }
        return count;
    }

    // Yêu cầu 9: Tìm ra sinh viên có điểm đầu vào cao nhất ở khoa
    public Student getStudentWithMaxEntryPoint() {
        if (students.isEmpty()) return null;
        Student maxStudent = students.get(0);
        for (Student s : students) {
            if (s.getEntryPoint() > maxStudent.getEntryPoint()) {
                maxStudent = s;
            }
        }
        return maxStudent;
    }

    // Yêu cầu 10: Lấy danh sách các sinh viên tại chức tại nơi liên kết đào tạo cho trước
    public List<InServiceStudent> getInServiceStudentsByLocation(String location) {
        List<InServiceStudent> result = new ArrayList<>();
        if (location == null || location.trim().isEmpty()) return result;
        String loc = location.trim().toLowerCase();

        for (Student s : students) {
            if (s instanceof InServiceStudent ins) {
                if (ins.getTrainingPartnership().toLowerCase().contains(loc)) {
                    result.add(ins);
                }
            }
        }
        return result;
    }

    // Yêu cầu 11: Lấy danh sách sinh viên có điểm trung bình ở học kỳ gần nhất >= 8.0
    public List<Student> getStudentsWithLatestGPAAtLeast8() {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            AcademicResult latest = s.getLatestAcademicResult();
            if (latest != null && latest.getSemesterGPA() >= 8.0) {
                result.add(s);
            }
        }
        return result;
    }

    // Yêu cầu 12: Tìm sinh viên có điểm trung bình học kỳ cao nhất (ở bất kỳ học kỳ nào)
    public Student getStudentWithMaxSemesterGPA() {
        if (students.isEmpty()) return null;
        Student maxStudent = null;
        double maxGPA = -1.0;

        for (Student s : students) {
            double studentMax = s.getMaxSemesterGPA();
            if (studentMax > maxGPA) {
                maxGPA = studentMax;
                maxStudent = s;
            }
        }
        return maxStudent;
    }

    // Yêu cầu 13: Sắp xếp danh sách sinh viên tăng dần theo loại và giảm dần theo năm vào học
    // (Chính quy trước, Tại chức sau; nếu cùng loại thì sắp xếp theo năm vào học giảm dần)
    public void sortStudentsByTypeAndYear() {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                // Tăng dần theo loại: RegularStudent (1) trước InServiceStudent (2)
                int type1 = s1.isRegularStudent() ? 1 : 2;
                int type2 = s2.isRegularStudent() ? 1 : 2;
                int typeCompare = Integer.compare(type1, type2);
                if (typeCompare != 0) {
                    return typeCompare;
                }
                // Giảm dần theo năm vào học
                return Integer.compare(s2.getYearOfAdmission(), s1.getYearOfAdmission());
            }
        });
    }

    // Yêu cầu 14: Thống kê số lượng sinh viên theo năm vào học (Ví dụ: 2020: 100, 2019: 90, ...)
    public Map<Integer, Integer> countStudentsByYear() {
        Map<Integer, Integer> stats = new TreeMap<>(Collections.reverseOrder()); // Sắp xếp theo năm mới nhất trước
        for (Student s : students) {
            int year = s.getYearOfAdmission();
            stats.put(year, stats.getOrDefault(year, 0) + 1);
        }
        return stats;
    }

    public void input(Scanner scanner) {
        System.out.print("Nhập tên khoa: ");
        setDepartmentName(scanner.nextLine());
    }

    public void output() {
        System.out.println("==========================================================================");
        System.out.println(" KHOA: " + departmentName + " | TỔNG SỐ SINH VIÊN: " + students.size() +
                " (Chính quy: " + getTotalRegularStudents() + ", Tại chức: " + (students.size() - getTotalRegularStudents()) + ")");
        System.out.println("==========================================================================");
        for (int i = 0; i < students.size(); i++) {
            System.out.print((i + 1) + ". ");
            students.get(i).output();
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", totalStudents=" + students.size() +
                '}';
    }
}
