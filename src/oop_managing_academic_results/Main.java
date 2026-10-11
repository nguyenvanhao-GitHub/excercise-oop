package oop_managing_academic_results;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManagement university = new StudentManagement();

    public static void main(String[] args) {
        initSampleData();

        int choice;
        do {
            System.out.println("\n========== HỆ THỐNG QUẢN LÝ KẾT QUẢ HỌC TẬP SINH VIÊN (BÀI 15) ==========");
            System.out.println("1.  Thêm sinh viên mới (Chính quy / Tại chức) vào khoa");
            System.out.println("2.  Hiển thị danh sách sinh viên toàn bộ các khoa");
            System.out.println("3.  Xác định tổng số sinh viên chính quy của mỗi khoa");
            System.out.println("4.  Lấy điểm trung bình học kỳ của sinh viên theo học kỳ cho trước");
            System.out.println("5.  Tìm sinh viên có điểm đầu vào cao nhất ở mỗi khoa");
            System.out.println("6.  Lấy danh sách sinh viên tại chức theo nơi liên kết đào tạo");
            System.out.println("7.  Lấy danh sách sinh viên có ĐTB học kỳ gần nhất >= 8.0");
            System.out.println("8.  Tìm sinh viên có ĐTB học kỳ cao nhất ở mỗi khoa");
            System.out.println("9.  Sắp xếp sinh viên: Tăng dần theo loại, Giảm dần theo năm vào học");
            System.out.println("10. Thống kê số lượng sinh viên theo năm vào học ở mỗi khoa");
            System.out.println("11. Kiểm thử tính năng Copy Constructor (Sao chép đối tượng)");
            System.out.println("0.  Thoát khỏi chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            try {
                switch (choice) {
                    case 1 -> handleAddStudent();
                    case 2 -> university.showAllDepartments();
                    case 3 -> handleTotalRegular();
                    case 4 -> handleGPABySemester();
                    case 5 -> handleMaxEntryPoint();
                    case 6 -> handleInServiceByLocation();
                    case 7 -> handleLatestGPAAtLeast8();
                    case 8 -> handleMaxSemesterGPA();
                    case 9 -> handleSortByTypeAndYear();
                    case 10 -> handleCountByYear();
                    case 11 -> handleTestCopyConstructor();
                    case 0 -> System.out.println(">> Đã thoát chương trình Quản lý kết quả học tập.");
                    default -> System.out.println(">> Lựa chọn không hợp lệ, vui lòng chọn lại!");
                }
            } catch (Exception e) {
                System.err.println(">> Lỗi thực thi: " + e.getMessage());
            }
        } while (choice != 0);
    }

    private static Department selectDepartment() {
        List<Department> depts = university.getDepartments();
        if (depts.isEmpty()) {
            System.out.println("Chưa có khoa nào trong hệ thống!");
            return null;
        }
        System.out.println("Chọn khoa:");
        for (int i = 0; i < depts.size(); i++) {
            System.out.println((i + 1) + ". " + depts.get(i).getDepartmentName());
        }
        System.out.print(">> Lựa chọn (1 - " + depts.size() + "): ");
        int idx = Integer.parseInt(scanner.nextLine().trim()) - 1;
        if (idx >= 0 && idx < depts.size()) {
            return depts.get(idx);
        }
        System.out.println("Khoa không hợp lệ!");
        return null;
    }

    private static void handleAddStudent() {
        Department dept = selectDepartment();
        if (dept == null) return;

        System.out.println("Chọn loại sinh viên:");
        System.out.println("1. Sinh viên chính quy (Regular Student)");
        System.out.println("2. Sinh viên tại chức (In-Service Student)");
        System.out.print(">> Lựa chọn: ");
        int type = Integer.parseInt(scanner.nextLine().trim());

        Student student;
        if (type == 1) {
            student = new RegularStudent();
        } else if (type == 2) {
            student = new InServiceStudent();
        } else {
            System.out.println("Loại sinh viên không hợp lệ!");
            return;
        }

        student.input(scanner);
        dept.addStudent(student);
        System.out.println(">> Thêm sinh viên thành công vào khoa " + dept.getDepartmentName() + "!");
    }

    private static void handleTotalRegular() {
        for (Department d : university.getDepartments()) {
            System.out.println("Khoa [" + d.getDepartmentName() + "] - Tổng sinh viên chính quy: " +
                    d.getTotalRegularStudents() + " / " + d.getStudents().size());
        }
    }

    private static void handleGPABySemester() {
        System.out.print("Nhập mã sinh viên cần tra cứu: ");
        String id = scanner.nextLine().trim();
        Student s = university.findStudentById(id);
        if (s == null) {
            System.out.println("Không tìm thấy sinh viên có mã: " + id);
            return;
        }

        System.out.print("Nhập tên học kỳ (ví dụ: HK1, HK2): ");
        String sem = scanner.nextLine().trim();
        Double gpa = s.getGPABySemester(sem);
        if (gpa != null) {
            System.out.println(">> Sinh viên: " + s.getFullName() + " | ĐTB học kỳ " + sem + ": " + gpa);
        } else {
            System.out.println("Sinh viên chưa có điểm ở học kỳ: " + sem);
        }
    }

    private static void handleMaxEntryPoint() {
        for (Department d : university.getDepartments()) {
            Student maxS = d.getStudentWithMaxEntryPoint();
            System.out.println("----- Khoa: " + d.getDepartmentName() + " -----");
            if (maxS != null) {
                System.out.println(">> Sinh viên có điểm đầu vào cao nhất: " + maxS.getFullName() +
                        " (Điểm: " + maxS.getEntryPoint() + ")");
            } else {
                System.out.println("Khoa chưa có sinh viên nào.");
            }
        }
    }

    private static void handleInServiceByLocation() {
        System.out.print("Nhập nơi liên kết đào tạo cần tìm (ví dụ: Đồng Nai, Cà Mau): ");
        String loc = scanner.nextLine().trim();

        for (Department d : university.getDepartments()) {
            List<InServiceStudent> list = d.getInServiceStudentsByLocation(loc);
            System.out.println("----- Khoa: " + d.getDepartmentName() + " (" + list.size() + " SV tại chức tại " + loc + ") -----");
            for (InServiceStudent ins : list) {
                ins.output();
            }
        }
    }

    private static void handleLatestGPAAtLeast8() {
        for (Department d : university.getDepartments()) {
            List<Student> list = d.getStudentsWithLatestGPAAtLeast8();
            System.out.println("----- Khoa: " + d.getDepartmentName() + " (ĐTB kỳ gần nhất >= 8.0: " + list.size() + " SV) -----");
            for (Student s : list) {
                AcademicResult latest = s.getLatestAcademicResult();
                System.out.println("  - " + s.getFullName() + " (" + (s.isRegularStudent() ? "Chính quy" : "Tại chức") +
                        ") | " + latest.getSemesterName() + ": " + latest.getSemesterGPA());
            }
        }
    }

    private static void handleMaxSemesterGPA() {
        for (Department d : university.getDepartments()) {
            Student maxS = d.getStudentWithMaxSemesterGPA();
            System.out.println("----- Khoa: " + d.getDepartmentName() + " -----");
            if (maxS != null) {
                System.out.println(">> Sinh viên có điểm học kỳ cao nhất: " + maxS.getFullName() +
                        " (ĐTB cao nhất đạt: " + maxS.getMaxSemesterGPA() + ")");
            } else {
                System.out.println("Khoa chưa có sinh viên nào có kết quả học tập.");
            }
        }
    }

    private static void handleSortByTypeAndYear() {
        Department d = selectDepartment();
        if (d == null) return;
        d.sortStudentsByTypeAndYear();
        System.out.println(">> Đã sắp xếp sinh viên theo loại (tăng dần: Chính quy -> Tại chức) và theo năm vào học (giảm dần):");
        d.output();
    }

    private static void handleCountByYear() {
        for (Department d : university.getDepartments()) {
            System.out.println("----- Thống kê số lượng sinh viên theo năm vào học: " + d.getDepartmentName() + " -----");
            Map<Integer, Integer> stats = d.countStudentsByYear();
            for (Map.Entry<Integer, Integer> entry : stats.entrySet()) {
                System.out.println("  Năm " + entry.getKey() + ": " + entry.getValue() + " sinh viên");
            }
        }
    }

    private static void handleTestCopyConstructor() {
        System.out.println("\n--- KIỂM THỬ COPY CONSTRUCTOR ---");
        List<Department> depts = university.getDepartments();
        if (depts.isEmpty()) return;

        Department originalDept = depts.get(0);
        System.out.println("1. Tạo bản sao của khoa '" + originalDept.getDepartmentName() + "' bằng Copy Constructor...");
        Department copiedDept = new Department(originalDept);
        copiedDept.setDepartmentName(originalDept.getDepartmentName() + " (Bản sao)");

        System.out.println("Khoa gốc: " + originalDept);
        System.out.println("Khoa sao chép: " + copiedDept);

        if (!originalDept.getStudents().isEmpty()) {
            Student origStudent = originalDept.getStudents().get(0);
            Student copiedStudent;
            if (origStudent instanceof RegularStudent reg) {
                copiedStudent = new RegularStudent(reg);
            } else if (origStudent instanceof InServiceStudent ins) {
                copiedStudent = new InServiceStudent(ins);
            } else {
                copiedStudent = new Student(origStudent);
            }
            copiedStudent.setFullName(origStudent.getFullName() + " [Copy]");
            System.out.println("\nSinh viên gốc: " + origStudent);
            System.out.println("Sinh viên sao chép: " + copiedStudent);
            System.out.println(">> Copy constructor hoạt động độc lập và tạo bản sao sâu (deep copy) thành công!");
        }
    }

    private static void initSampleData() {
        Department cntt = new Department("Khoa Công Nghệ Thông Tin");
        Department dtvt = new Department("Khoa Điện Tử Viễn Thông");

        // Thêm SV vào Khoa CNTT
        RegularStudent r1 = new RegularStudent("SV01", "Nguyễn Văn Tuấn", LocalDate.of(2002, 3, 15), 2020, 27.5, null);
        r1.addAcademicResult(new AcademicResult("HK1", 8.2));
        r1.addAcademicResult(new AcademicResult("HK2", 8.6));
        r1.addAcademicResult(new AcademicResult("HK3", 9.1));

        RegularStudent r2 = new RegularStudent("SV02", "Trần Mai Phương", LocalDate.of(2003, 7, 22), 2021, 28.5, null);
        r2.addAcademicResult(new AcademicResult("HK1", 7.8));
        r2.addAcademicResult(new AcademicResult("HK2", 8.3));

        RegularStudent r3 = new RegularStudent("SV03", "Lê Bảo Nam", LocalDate.of(2001, 10, 5), 2019, 25.0, null);
        r3.addAcademicResult(new AcademicResult("HK1", 6.5));
        r3.addAcademicResult(new AcademicResult("HK2", 7.2));

        InServiceStudent tc1 = new InServiceStudent("TC01", "Hoàng Văn Hùng", LocalDate.of(1998, 12, 10), 2020, 22.0, null, "Đồng Nai");
        tc1.addAcademicResult(new AcademicResult("HK1", 8.0));
        tc1.addAcademicResult(new AcademicResult("HK2", 8.4));

        InServiceStudent tc2 = new InServiceStudent("TC02", "Phạm Thị Lan", LocalDate.of(1999, 4, 18), 2021, 23.5, null, "Cà Mau");
        tc2.addAcademicResult(new AcademicResult("HK1", 7.0));
        tc2.addAcademicResult(new AcademicResult("HK2", 7.5));

        InServiceStudent tc3 = new InServiceStudent("TC03", "Vũ Đình Trọng", LocalDate.of(1997, 8, 30), 2019, 21.0, null, "Đồng Nai");
        tc3.addAcademicResult(new AcademicResult("HK1", 8.5));
        tc3.addAcademicResult(new AcademicResult("HK2", 8.8));

        cntt.addStudent(r1);
        cntt.addStudent(r2);
        cntt.addStudent(r3);
        cntt.addStudent(tc1);
        cntt.addStudent(tc2);
        cntt.addStudent(tc3);

        // Thêm SV vào Khoa ĐTVT
        RegularStudent d1 = new RegularStudent("DT01", "Đỗ Quốc Bảo", LocalDate.of(2002, 9, 1), 2020, 26.0, null);
        d1.addAcademicResult(new AcademicResult("HK1", 7.5));
        d1.addAcademicResult(new AcademicResult("HK2", 8.1));

        InServiceStudent dtc1 = new InServiceStudent("DTC01", "Bùi Thanh Hằng", LocalDate.of(1999, 1, 12), 2021, 24.0, null, "Bình Dương");
        dtc1.addAcademicResult(new AcademicResult("HK1", 8.2));

        dtvt.addStudent(d1);
        dtvt.addStudent(dtc1);

        university.addDepartment(cntt);
        university.addDepartment(dtvt);
    }
}
