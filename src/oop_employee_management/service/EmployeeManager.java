package oop_employee_management.service;

import oop_employee_management.entity.Employee;
import oop_employee_management.entity.Experience;
import oop_employee_management.entity.Fresher;
import oop_employee_management.entity.Intern;
import oop_employee_management.enums.EmployeeType;
import oop_employee_management.util.FileService;
import oop_employee_management.validator.EmployeeValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {
    private final List<Employee> employees;

    public EmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public void insert(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Thông tin nhân viên không được rỗng!");
        }
        if (findById(employee.getId()) != null) {
            throw new IllegalArgumentException("Mã nhân viên (ID: " + employee.getId() + ") đã tồn tại trong hệ thống!");
        }
        // Validate dữ liệu nhân viên
        EmployeeValidator.validateEmployee(
                employee.getFullName(),
                employee.getBirthDay(),
                employee.getPhone(),
                employee.getEmail()
        );
        this.employees.add(employee);
        Employee.setEmployeeCount(this.employees.size());
    }

    public boolean update(String id, Employee newInfo) {
        Employee existingEmployee = findById(id);
        if (existingEmployee == null) {
            return false;
        }

        // Validate dữ liệu mới
        EmployeeValidator.validateEmployee(
                newInfo.getFullName(),
                newInfo.getBirthDay(),
                newInfo.getPhone(),
                newInfo.getEmail()
        );

        existingEmployee.setFullName(newInfo.getFullName());
        existingEmployee.setBirthDay(newInfo.getBirthDay());
        existingEmployee.setPhone(newInfo.getPhone());
        existingEmployee.setEmail(newInfo.getEmail());
        existingEmployee.setCertificates(newInfo.getCertificates());

        if (existingEmployee instanceof Experience exp && newInfo instanceof Experience newExp) {
            exp.setExpInYear(newExp.getExpInYear());
            exp.setProSkill(newExp.getProSkill());
        } else if (existingEmployee instanceof Fresher fresher && newInfo instanceof Fresher newFresher) {
            fresher.setGraduationDate(newFresher.getGraduationDate());
            fresher.setGraduationRank(newFresher.getGraduationRank());
            fresher.setEducation(newFresher.getEducation());
        } else if (existingEmployee instanceof Intern intern && newInfo instanceof Intern newIntern) {
            intern.setMajors(newIntern.getMajors());
            intern.setSemester(newIntern.getSemester());
            intern.setUniversityName(newIntern.getUniversityName());
        }

        return true;
    }

    public Employee findById(String id) {
        if (id == null) return null;
        return employees.stream()
                .filter(employee -> employee.getId().equalsIgnoreCase(id.trim()))
                .findFirst()
                .orElse(null);
    }

    public boolean deleteById(String id) {
        Employee employee = this.findById(id);
        if (employee == null) {
            return false;
        }
        this.employees.remove(employee);
        Employee.setEmployeeCount(this.employees.size());
        return true;
    }

    public List<Employee> findByType(EmployeeType type) {
        return this.employees.stream().filter(employee -> switch (type) {
            case EXPERIENCE -> employee instanceof Experience;
            case FRESHER -> employee instanceof Fresher;
            case INTERN -> employee instanceof Intern;
        }).collect(Collectors.toList());
    }

    public List<Employee> findAll() {
        return new ArrayList<>(this.employees);
    }

    // ==========================================
    // ĐỌC / GHI FILE TEXT
    // ==========================================
    public void saveToTextFile(String filePath) throws IOException {
        FileService.saveEmployeesToTextFile(filePath, this.employees);
    }

    public void loadFromTextFile(String filePath) throws IOException {
        List<Employee> loadedList = FileService.readEmployeesFromTextFile(filePath);
        this.employees.clear();
        this.employees.addAll(loadedList);
        Employee.setEmployeeCount(this.employees.size());
    }

    // ==========================================
    // ĐỌC / GHI FILE NHỊ PHÂN (SERIALIZATION)
    // ==========================================
    public void saveToBinaryFile(String filePath) throws IOException {
        FileService.saveEmployeesToBinaryFile(filePath, this.employees);
    }

    public void loadFromBinaryFile(String filePath) throws IOException, ClassNotFoundException {
        List<Employee> loadedList = FileService.readEmployeesFromBinaryFile(filePath);
        this.employees.clear();
        this.employees.addAll(loadedList);
        Employee.setEmployeeCount(this.employees.size());
    }
}
