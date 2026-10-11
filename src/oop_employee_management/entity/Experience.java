package oop_employee_management.entity;

import oop_employee_management.enums.EmployeeType;

import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee {
    private static final long serialVersionUID = 1L;

    private int expInYear;
    private String proSkill;

    public Experience() {
        super();
        setEmployeeType(EmployeeType.EXPERIENCE);
    }

    public Experience(String id, String fullName, LocalDate birthDay, String phone, String email, List<Certificate> certificates, int expInYear, String proSkill) {
        super(id, fullName, birthDay, phone, email, EmployeeType.EXPERIENCE, certificates);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Experience{" +
                super.toString() +
                ", expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                '}';
    }
}
