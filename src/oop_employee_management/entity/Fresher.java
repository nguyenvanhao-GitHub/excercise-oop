package oop_employee_management.entity;

import oop_employee_management.enums.EmployeeType;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee {
    private static final long serialVersionUID = 1L;

    private LocalDate graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
        super();
        setEmployeeType(EmployeeType.FRESHER);
    }

    public Fresher(String id, String fullName, LocalDate birthDay, String phone, String email, List<Certificate> certificates, LocalDate graduationDate, String graduationRank, String education) {
        super(id, fullName, birthDay, phone, email, EmployeeType.FRESHER, certificates);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fresher{" +
                super.toString() +
                ", graduationDate=" + graduationDate +
                ", graduationRank='" + graduationRank + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
