package oop_managing_academic_results;

import java.util.*;

public class StudentManagement {
    private final List<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            students.forEach(Student::output);
        }
    }

    public int getTotalRegularStudents() {
        int total = 0;
        for (Student student : students) {
            if (student.isRegularStudent()) {
                total++;
            }
        }
        return total;
    }

    public void getGPAStudent(String semester) {
        boolean found = false;
        for (Student student : students) {
            List<AcademicResult> results = student.getAcademicResults();
            if (results != null) {
                for (AcademicResult result : results) {
                    if (result.getSemesterName().equalsIgnoreCase(semester)) {
                        System.out.println("Student ID: " + student.getId() +
                                " | GPA in " + semester + ": " +
                                result.getSemesterGPA());
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("No records found for semester: " + semester);
        }
    }

    public Student getStudentEntryPointMax(Department department) {
        if (department == null) return null;

        List<Student> list = department.getStudents();

        if (list == null || list.isEmpty()) {
            return null;
        }

        Student maxStudent = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Student current = list.get(i);
            if (current.getEntryPoint() > maxStudent.getEntryPoint()) {
                maxStudent = current;
            }
        }
        return maxStudent;
    }
}