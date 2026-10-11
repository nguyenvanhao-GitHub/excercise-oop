package oop_employee_management.entity;

import oop_employee_management.enums.EmployeeType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String fullName;
    private LocalDate birthDay;
    private String phone;
    private String email;
    private EmployeeType employeeType;
    private static int employeeCount = 0;

    private List<Certificate> certificates;

    public Employee() {
        this.certificates = new ArrayList<>();
    }

    public Employee(String id, String fullName, LocalDate birthDay, String phone, String email, EmployeeType employeeType, List<Certificate> certificates) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        this.certificates = certificates != null ? certificates : new ArrayList<>();
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static void setEmployeeCount(int employeeCount) {
        Employee.employeeCount = employeeCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public abstract void showInfo();

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDay=" + birthDay +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", type=" + employeeType +
                ", certificates=" + certificates;
    }
}
