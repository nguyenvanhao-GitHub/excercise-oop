package oop_managing_academic_results;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RegularStudent extends Student {

    // 1. Constructor chuẩn (default)
    public RegularStudent() {
        super();
    }

    // 2. Constructor có tham số
    public RegularStudent(String id, String fullName, LocalDate dateOfBirth, int yearOfAdmission, double entryPoint, List<AcademicResult> academicResults) {
        super(id, fullName, dateOfBirth, yearOfAdmission, entryPoint, academicResults);
    }

    // 3. Constructor sao chép (copy constructor)
    public RegularStudent(RegularStudent other) {
        super(other);
    }

    @Override
    public boolean isRegularStudent() {
        return true;
    }

    @Override
    public void input(Scanner scanner) {
        super.input(scanner);
    }

    @Override
    public void output() {
        super.output();
    }

    @Override
    public String toString() {
        return "RegularStudent{" + super.toString() + "}";
    }
}
