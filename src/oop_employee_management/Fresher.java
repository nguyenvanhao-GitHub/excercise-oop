package oop_employee_management;

import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee {
    private LocalDate Graduation_date;
    private String Graduation_rank;
    private String Education;

    public Fresher() {
    }

    public Fresher(int ID, String FullName, LocalDate BirthDay, String Phone, String Email) {
        super(ID, FullName, BirthDay, Phone, Email);
    }

    public Fresher(int ID, String fullName, LocalDate birthDay, String phone, String email, List<Certificate> certificates, LocalDate graduation_date, String graduation_rank, String education) {
        super(ID, fullName, birthDay, phone, email, certificates);
        Graduation_date = graduation_date;
        Graduation_rank = graduation_rank;
        Education = education;
    }

    public LocalDate getGraduation_date() {
        return Graduation_date;
    }

    public void setGraduation_date(LocalDate graduation_date) {
        Graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return Graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        Graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    @Override
    public String toString() {
        return super.toString() + "Fresher{" +
                "Graduation_date=" + Graduation_date +
                ", Graduation_rank='" + Graduation_rank + '\'' +
                ", Education='" + Education + '\'' +
                '}';
    }

    @Override
    public void ShowInfo() {
        System.out.println(this);
    }

}
