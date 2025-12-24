package oop_managing_academic_results;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RegularStudent extends Student {
    public RegularStudent() {
    }

    public RegularStudent(String id, String fullName, LocalDate dateOfBirth, int yearOfAdmission, double entryPoint, List<AcademicResult> academicResults) {
        super(id, fullName, dateOfBirth, yearOfAdmission, entryPoint, academicResults);
    }

    @Override
    public void input(Scanner scanner){
        super.input(scanner);
    }

    @Override
    public void output(){
        super.output();
        System.out.println(" -> Regular Student");
    }

    @Override
    public boolean isRegularStudent() {
        return true;
    }
}
