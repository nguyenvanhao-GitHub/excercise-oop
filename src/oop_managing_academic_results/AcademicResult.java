package oop_managing_academic_results;

import java.util.Scanner;

public class AcademicResult {
    private String semesterName;
    private double semesterGPA;

    // 1. Constructor chuẩn (default)
    public AcademicResult() {
        this.semesterName = "";
        this.semesterGPA = 0.0;
    }

    // 2. Constructor có tham số
    public AcademicResult(String semesterName, double semesterGPA) {
        setSemesterName(semesterName);
        setSemesterGPA(semesterGPA);
    }

    // 3. Constructor sao chép (copy constructor)
    public AcademicResult(AcademicResult other) {
        if (other != null) {
            this.semesterName = other.semesterName;
            this.semesterGPA = other.semesterGPA;
        }
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        if (semesterName == null || semesterName.trim().isEmpty()) {
            throw new IllegalArgumentException("Tên học kỳ không được để trống!");
        }
        this.semesterName = semesterName.trim();
    }

    public double getSemesterGPA() {
        return semesterGPA;
    }

    public void setSemesterGPA(double semesterGPA) {
        if (semesterGPA < 0.0 || semesterGPA > 10.0) {
            throw new IllegalArgumentException("Điểm trung bình học kỳ phải từ 0.0 đến 10.0 (Giá trị nhập: " + semesterGPA + ")!");
        }
        this.semesterGPA = semesterGPA;
    }

    public void input(Scanner scanner) {
        System.out.print("  Nhập tên học kỳ (ví dụ: HK1, HK2): ");
        setSemesterName(scanner.nextLine());
        System.out.print("  Nhập điểm trung bình học kỳ (thang 10): ");
        setSemesterGPA(Double.parseDouble(scanner.nextLine().trim()));
    }

    public void output() {
        System.out.println("    - Học kỳ: " + semesterName + " | ĐTB: " + semesterGPA);
    }

    @Override
    public String toString() {
        return "[" + semesterName + ": " + semesterGPA + "]";
    }
}
