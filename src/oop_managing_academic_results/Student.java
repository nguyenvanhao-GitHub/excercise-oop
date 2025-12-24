package oop_managing_academic_results;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String id;
    private String fullName;
    private LocalDate dateOfBirth;
    private int yearOfAdmission;
    private double entryPoint;
    private List<AcademicResult> academicResults = new ArrayList<>();

    public Student() {
    }

    public Student(String id, String fullName, LocalDate dateOfBirth, int yearOfAdmission, double entryPoint, List<AcademicResult> academicResults) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.yearOfAdmission = yearOfAdmission;
        this.entryPoint = entryPoint;
        this.academicResults = academicResults;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty()){
            throw new IllegalArgumentException("Full name cannot be empty");
        }
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dobInput) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate localDate = LocalDate.parse(dobInput, formatter);

            if (localDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Date of birth cannot be in the future");
            }

            this.dateOfBirth = localDate;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Date of birth is not valid (dd/MM/yyyy)");
        }
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        if (yearOfAdmission < 1900 || yearOfAdmission > 2100) {
            throw new IllegalArgumentException("Year of admission must be between 1900 and 2100");
        }
        this.yearOfAdmission = yearOfAdmission;
    }

    public double getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(double entryPoint) {
        if (entryPoint < 0 || entryPoint > 100) {
            throw new IllegalArgumentException("Entry point must be between 0 and 100");
        }

        this.entryPoint = entryPoint;
    }

    public List<AcademicResult> getAcademicResults() {
        return academicResults;
    }

    public void setAcademicResults(List<AcademicResult> academicResults) {
        this.academicResults = academicResults;
    }

    public void input(Scanner scanner){
        System.out.println("Enter Student ID: ");
        setId(scanner.next());
        System.out.println("Enter Student Full Name: ");
        setFullName(scanner.next());
        System.out.println("Enter Student Date of Birth (dd/MM/yyyy): ");
        String dobInput = scanner.next();
        setDateOfBirth(dobInput);
        scanner.nextLine();
        System.out.println("Enter Student Year Of Admission: ");
        setYearOfAdmission(scanner.nextInt());
        System.out.println("Enter Student Entry Point: ");
        setEntryPoint(scanner.nextDouble());

        System.out.println("Enter number of Academic Results: ");
        int numberOfAcademicResults = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfAcademicResults; i++) {
            System.out.println("Enter Student Academic Result: " + (i + 1));
            AcademicResult academicResult = new AcademicResult();
            academicResult.input(scanner);
            academicResults.add(academicResult);
        }
    }

    public void output(){
        System.out.println("Student ID: " + id);
        System.out.println("Student Full Name: " + fullName);
        System.out.println("Student Date of Birth: " + dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Student Year Of Admission: " + yearOfAdmission);
        System.out.println("Student Entry Point: " + entryPoint);
        System.out.println("Academic Results: " + academicResults.size());
        for (AcademicResult academicResult : academicResults) {
            academicResult.output();
        }
    }

    public boolean isRegularStudent() {
        return false;
    }
}
