package oop_managing_academic_results;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class InServiceStudent extends Student {
    private String trainingPartnership; // Nơi liên kết đào tạo

    // 1. Constructor chuẩn (default)
    public InServiceStudent() {
        super();
        this.trainingPartnership = "";
    }

    // 2. Constructor có tham số
    public InServiceStudent(String id, String fullName, LocalDate dateOfBirth, int yearOfAdmission, double entryPoint, List<AcademicResult> academicResults, String trainingPartnership) {
        super(id, fullName, dateOfBirth, yearOfAdmission, entryPoint, academicResults);
        setTrainingPartnership(trainingPartnership);
    }

    // 3. Constructor sao chép (copy constructor)
    public InServiceStudent(InServiceStudent other) {
        super(other);
        if (other != null) {
            this.trainingPartnership = other.trainingPartnership;
        }
    }

    public String getTrainingPartnership() {
        return trainingPartnership;
    }

    public void setTrainingPartnership(String trainingPartnership) {
        if (trainingPartnership == null || trainingPartnership.trim().isEmpty()) {
            throw new IllegalArgumentException("Nơi liên kết đào tạo không được để trống!");
        }
        this.trainingPartnership = trainingPartnership.trim();
    }

    @Override
    public boolean isRegularStudent() {
        return false;
    }

    @Override
    public void input(Scanner scanner) {
        super.input(scanner);
        System.out.print("Nhập nơi liên kết đào tạo (ví dụ: Đồng Nai, Cà Mau): ");
        setTrainingPartnership(scanner.nextLine());
    }

    @Override
    public void output() {
        super.output();
        System.out.println("  Nơi liên kết đào tạo: " + trainingPartnership);
    }

    @Override
    public String toString() {
        return "InServiceStudent{" + super.toString() +
                ", trainingPartnership='" + trainingPartnership + '\'' +
                '}';
    }
}
