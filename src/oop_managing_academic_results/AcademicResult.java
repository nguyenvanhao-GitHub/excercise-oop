package oop_managing_academic_results;

import java.util.Scanner;

public class AcademicResult {
    private String semesterName;
    private double semesterGPA;

    public AcademicResult() {
    }

    public AcademicResult(String semesterName, double semesterGPA) {
        this.semesterName = semesterName;
        this.semesterGPA = semesterGPA;
    }

    public double getSemesterGPA() {
        return semesterGPA;
    }

    public void setSemesterGPA(double semesterGPA) {
        this.semesterGPA = semesterGPA;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public void input(Scanner scanner){
        System.out.print("Enter semester name: ");
        setSemesterName(scanner.next());
        System.out.print("Enter semester GPA: ");
        setSemesterGPA(scanner.nextDouble());
    }

    public void output(){
        System.out.println("Semester Name: " + semesterName);
        System.out.println("Semester GPA: " + semesterGPA);
    }
}
