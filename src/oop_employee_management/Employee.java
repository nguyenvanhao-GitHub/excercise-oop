package oop_employee_management;

import java.time.LocalDate;
import java.util.List;

public abstract class Employee {
    private int ID;
    private String FullName;
    private LocalDate BirthDay;
    private String Phone;
    private String Email;
    protected static int Employee_type;
    protected static int Employee_count = 0;
    private List<Certificate> certificates;

    public Employee() {
    }

    public Employee(int ID, String fullName, LocalDate birthDay, String phone, String email) {
        this.ID = ID;
        FullName = fullName;
        BirthDay = birthDay;
        Phone = phone;
        Email = email;
    }

    public Employee(int ID, String fullName, LocalDate birthDay, String phone, String email, List<Certificate> certificates) {
        this.ID = ID;
        this.FullName = fullName;
        this.BirthDay = birthDay;
        this.Phone = phone;
        this.Email = email;
        this.certificates = certificates;
        Employee_count++;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public LocalDate getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        BirthDay = birthDay;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", FullName='" + FullName + '\'' +
                ", BirthDay=" + BirthDay +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", certificates=" + certificates +
                '}';
    }

    public abstract void ShowInfo();

}
