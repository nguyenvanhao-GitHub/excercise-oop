package oop_managing_academic_results;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentManagement studentManagement = new StudentManagement();

        Department department = new Department();
        System.out.println("--- Setup Department Info First ---");
        department.input(input);

        int choose;
        do {
            System.out.println("\n========== STUDENT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Student (Regular/InService)");
            System.out.println("2. Show All Students");
            System.out.println("3. Count Total Regular Students");
            System.out.println("4. Show GPA by Semester");
            System.out.println("5. Find Student with Max Entry Point in Department");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choose = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                choose = -1;
            }

            switch (choose) {
                case 1:
                    System.out.println("--- Add New Student ---");
                    System.out.println("1. Regular Student");
                    System.out.println("2. In-Service Student");
                    System.out.print("Choose type: ");
                    int type = Integer.parseInt(input.nextLine());

                    Student student = null;
                    if (type == 1) {
                        student = new RegularStudent();
                    } else if (type == 2) {
                        student = new InServiceStudent();
                    } else {
                        System.out.println("Invalid type selected!");
                        break;
                    }

                    if (student != null) {
                        student.input(input);
                        studentManagement.addStudent(student);
                        department.addStudent(student);
                        System.out.println("Add student success!");
                    }
                    break;

                case 2:
                    System.out.println("--- List of Students ---");
                    studentManagement.showAllStudents();
                    break;

                case 3:
                    int totalRegular = studentManagement.getTotalRegularStudents();
                    System.out.println("Total Regular Students: " + totalRegular);
                    break;

                case 4:
                    System.out.print("Enter semester name to find GPA: ");
                    String semesterName = input.nextLine();
                    studentManagement.getGPAStudent(semesterName);
                    break;

                case 5:
                    Student maxStudent = studentManagement.getStudentEntryPointMax(department);
                    if (maxStudent != null) {
                        System.out.println("Student with MAX entry point in " + department.getDepartmentName() + ":");
                        maxStudent.output();
                    } else {
                        System.out.println("No students found in this department.");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Wrong choice! Please try again.");
                    break;
            }

        } while (choose != 0);
    }
}