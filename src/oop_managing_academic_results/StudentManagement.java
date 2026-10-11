package oop_managing_academic_results;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private final List<Department> departments;

    public StudentManagement() {
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        if (department != null) {
            this.departments.add(department);
        }
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Department findDepartmentByName(String name) {
        if (name == null) return null;
        for (Department d : departments) {
            if (d.getDepartmentName().equalsIgnoreCase(name.trim())) {
                return d;
            }
        }
        return null;
    }

    public Student findStudentById(String id) {
        if (id == null) return null;
        for (Department d : departments) {
            for (Student s : d.getStudents()) {
                if (s.getId().equalsIgnoreCase(id.trim())) {
                    return s;
                }
            }
        }
        return null;
    }

    public void showAllDepartments() {
        if (departments.isEmpty()) {
            System.out.println("Hệ thống hiện chưa có khoa nào.");
            return;
        }
        for (Department d : departments) {
            d.output();
            System.out.println();
        }
    }
}
