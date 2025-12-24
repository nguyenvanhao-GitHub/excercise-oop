package oop_employee_management;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private final List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public EmployeeManager(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void updateEmployee(int ID, Employee newEmployee) {
        Employee updatedEmployee = getByID(ID);

        if (updatedEmployee != null) {
            updatedEmployee.setFullName(newEmployee.getFullName());
            updatedEmployee.setBirthDay(newEmployee.getBirthDay());
            updatedEmployee.setPhone(newEmployee.getPhone());
            updatedEmployee.setEmail(newEmployee.getEmail());
        } else {
            System.out.println("Employee not found");
        }
    }

    public Employee getByID(int ID) {
        return employees.stream().filter(employee -> employee.getID() == ID).findFirst().orElse(null);
    }

    public boolean deleteEmployee(int ID) {
        Employee deletedEmployee = getByID(ID);

        if (deletedEmployee != null) {
            employees.remove(deletedEmployee);
            return true;
        }
        return false;
    }


    public void DownCasting(Employee employee) {
        if (employee instanceof Experience) {
            Experience experience = (Experience) employee;
            experience.ShowInfo();
        } else if (employee instanceof Fresher) {
            Fresher fresher = (Fresher) employee;
            fresher.ShowInfo();
        } else if (employee instanceof Intern) {
            Intern intern = (Intern) employee;
            intern.ShowInfo();
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void showEmployees() {
        for (Employee employee : getEmployees()) {
            DownCasting(employee);
        }
    }
}
