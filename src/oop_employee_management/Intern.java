package oop_employee_management;

import java.time.LocalDate;
import java.util.List;

public class Intern extends Employee {

    private String Majors;
    private String Semester;
    private String University_name;

    public Intern() {
    }

    public Intern(int ID, String FullName, LocalDate BirthDay, String Phone, String Email) {
        super(ID, FullName, BirthDay, Phone, Email);
    }

    public Intern(int ID, String fullName, LocalDate birthDay, String phone, String email, List<Certificate> certificates, String majors, String semester, String university_name) {
        super(ID, fullName, birthDay, phone, email, certificates);
        Majors = majors;
        Semester = semester;
        University_name = university_name;
    }

    public String getMajors() {
        return Majors;
    }

    public void setMajors(String majors) {
        Majors = majors;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUniversity_name() {
        return University_name;
    }

    public void setUniversity_name(String university_name) {
        University_name = university_name;
    }

    @Override
    public String toString() {
        return super.toString() + "Intern{" +
                "Majors='" + Majors + '\'' +
                ", Semester='" + Semester + '\'' +
                ", University_name='" + University_name + '\'' +
                '}';
    }

    @Override
    public void ShowInfo() {
        System.out.println(this);
    }
}
