package oop_managing_academic_results;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Department {
    private String departmentName;
    private List<Student> students;

    public Department() {
        this.students = new ArrayList<>();
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.students = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.trim().isEmpty()){
            System.out.println("Invalid name, setting to Default.");
            this.departmentName = "Default Department";
        } else {
            this.departmentName = departmentName;
        }
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void input(Scanner scanner) {
        System.out.print("Enter department name: ");
        setDepartmentName(scanner.nextLine());
    }

    public void output() {
        System.out.println("Department Name: " + departmentName);
        System.out.println("Total Students in Dept: " + students.size());
        for (Student student : students){
            student.output();
        }
    }
}