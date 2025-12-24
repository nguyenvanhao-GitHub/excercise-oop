package oop_managing_academic_results;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class InServiceStudent extends Student{
    private String trainingPartnership;

    public InServiceStudent() {
    }

    public InServiceStudent(String id, String fullName, LocalDate dateOfBirth, int yearOfAdmission, double entryPoint, List<AcademicResult> academicResults, String trainingPartnership) {
        super(id, fullName, dateOfBirth, yearOfAdmission, entryPoint, academicResults);
        this.trainingPartnership = trainingPartnership;
    }

    public String getTrainingPartnership() {
        return trainingPartnership;
    }

    public void setTrainingPartnership(String trainingPartnership) {
        if (trainingPartnership == null || trainingPartnership.isEmpty()){
            throw new IllegalArgumentException("Training partnership cannot be null or empty");
        }

        this.trainingPartnership = trainingPartnership;
    }

    @Override
    public void input(Scanner scanner){
        super.input(scanner);
        System.out.println("Enter training partnership: ");
        setTrainingPartnership(scanner.next());
    }

    @Override
    public void output(){
        super.output();
        System.out.println("Training Partnership: " + trainingPartnership);
    }
}
