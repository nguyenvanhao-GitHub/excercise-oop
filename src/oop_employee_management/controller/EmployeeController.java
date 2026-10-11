package oop_employee_management.controller;

import oop_employee_management.entity.Employee;
import oop_employee_management.enums.EmployeeType;
import oop_employee_management.exception.BirthdayException;
import oop_employee_management.exception.EmailException;
import oop_employee_management.exception.FullNameException;
import oop_employee_management.exception.PhoneException;
import oop_employee_management.service.EmployeeManager;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class EmployeeController {
    private final EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    public boolean addEmployee(Employee employee) {
        try {
            this.employeeManager.insert(employee);
            System.out.println(">> [SUCCESS] Thêm nhân viên thành công!");
            return true;
        } catch (BirthdayException | EmailException | PhoneException | FullNameException e) {
            System.err.println(">> [LỖI DỮ LIỆU]: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            System.err.println(">> [LỖI NGHIỆP VỤ]: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(">> [LỖI HỆ THỐNG]: " + e.getMessage());
            return false;
        }
    }

    public boolean updateEmployee(String id, Employee employee) {
        try {
            boolean isUpdated = this.employeeManager.update(id, employee);
            if (isUpdated) {
                System.out.println(">> [SUCCESS] Cập nhật thông tin nhân viên thành công!");
                return true;
            } else {
                System.err.println(">> [LỖI]: Không tìm thấy nhân viên có mã ID: " + id);
                return false;
            }
        } catch (BirthdayException | EmailException | PhoneException | FullNameException e) {
            System.err.println(">> [LỖI DỮ LIỆU]: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(">> [LỖI HỆ THỐNG]: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteEmployee(String id) {
        try {
            boolean isDeleted = this.employeeManager.deleteById(id);
            if (isDeleted) {
                System.out.println(">> [SUCCESS] Xóa nhân viên thành công!");
                return true;
            } else {
                System.err.println(">> [LỖI]: Không tìm thấy nhân viên có mã ID: " + id);
                return false;
            }
        } catch (Exception e) {
            System.err.println(">> [LỖI HỆ THỐNG]: " + e.getMessage());
            return false;
        }
    }

    public Employee findEmployeeById(String id) {
        try {
            return this.employeeManager.findById(id);
        } catch (Exception e) {
            System.err.println(">> [LỖI]: " + e.getMessage());
            return null;
        }
    }

    public List<Employee> findEmployeesByType(EmployeeType type) {
        try {
            return this.employeeManager.findByType(type);
        } catch (Exception e) {
            System.err.println(">> [LỖI]: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<Employee> getAllEmployees() {
        try {
            return this.employeeManager.findAll();
        } catch (Exception e) {
            System.err.println(">> [LỖI]: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public int getEmployeeCount() {
        return Employee.getEmployeeCount();
    }

    // ==========================================
    // XỬ LÝ FILE VĂN BẢN (.TXT)
    // ==========================================
    public boolean saveToTextFile(String filePath) {
        try {
            this.employeeManager.saveToTextFile(filePath);
            System.out.println(">> [SUCCESS] Đã lưu danh sách nhân viên vào file text: " + filePath);
            return true;
        } catch (IOException e) {
            System.err.println(">> [LỖI GHI FILE TEXT]: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(">> [LỖI HỆ THỐNG]: " + e.getMessage());
            return false;
        }
    }

    public boolean loadFromTextFile(String filePath) {
        try {
            this.employeeManager.loadFromTextFile(filePath);
            System.out.println(">> [SUCCESS] Đã đọc thành công dữ liệu từ file text: " + filePath);
            System.out.println(">> Tổng số nhân viên đã nạp: " + getEmployeeCount());
            return true;
        } catch (IOException e) {
            System.err.println(">> [LỖI ĐỌC FILE TEXT]: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(">> [LỖI HỆ THỐNG]: " + e.getMessage());
            return false;
        }
    }

    // ==========================================
    // XỬ LÝ FILE NHỊ PHÂN (.DAT)
    // ==========================================
    public boolean saveToBinaryFile(String filePath) {
        try {
            this.employeeManager.saveToBinaryFile(filePath);
            System.out.println(">> [SUCCESS] Đã lưu danh sách nhân viên vào file nhị phân: " + filePath);
            return true;
        } catch (IOException e) {
            System.err.println(">> [LỖI GHI FILE NHỊ PHÂN]: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(">> [LỖI HỆ THỐNG]: " + e.getMessage());
            return false;
        }
    }

    public boolean loadFromBinaryFile(String filePath) {
        try {
            this.employeeManager.loadFromBinaryFile(filePath);
            System.out.println(">> [SUCCESS] Đã đọc thành công dữ liệu từ file nhị phân: " + filePath);
            System.out.println(">> Tổng số nhân viên đã nạp: " + getEmployeeCount());
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(">> [LỖI ĐỌC FILE NHỊ PHÂN]: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.err.println(">> [LỖI HỆ THỐNG]: " + e.getMessage());
            return false;
        }
    }
}
