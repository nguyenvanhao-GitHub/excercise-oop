package oop_employee_management;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee {
    private int ExpInYear;
    private String ProSkill;

    public Experience() {
    }

    public Experience(int ID, String FullName, LocalDate BirthDay, String Phone, String Email) {
        super(ID, FullName, BirthDay, Phone, Email);
    }


    public Experience(int ID, String fullName, LocalDate birthDay, String phone, String email, List<Certificate> certificates, int expInYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, certificates);
        ExpInYear = expInYear;
        ProSkill = proSkill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int expInYear) {
        ExpInYear = expInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + "Experience{" +
                "ExpInYear=" + ExpInYear +
                ", ProSkill='" + ProSkill + '\'' +
                '}';
    }

    @Override
    public void ShowInfo() {
        System.out.println(this);
    }
}
