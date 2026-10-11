package oop_employee_management.entity;

import oop_employee_management.enums.EmployeeType;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee {
    private static final long serialVersionUID = 1L;

    private String majors;
    private String semester;
    private String universityName;

    public Intern() {
        super();
        setEmployeeType(EmployeeType.INTERN);
    }

    public Intern(String id, String fullName, LocalDate birthDay, String phone, String email, List<Certificate> certificates, String majors, String semester, String universityName) {
        super(id, fullName, birthDay, phone, email, EmployeeType.INTERN, certificates);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Intern{" +
                super.toString() +
                ", majors='" + majors + '\'' +
                ", semester='" + semester + '\'' +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}
