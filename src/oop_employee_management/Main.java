package oop_employee_management;

import oop_employee_management.controller.EmployeeController;
import oop_employee_management.entity.*;
import oop_employee_management.enums.EmployeeType;
import oop_employee_management.service.EmployeeManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final EmployeeController controller = new EmployeeController(new EmployeeManager());

    private static final String DEFAULT_TEXT_FILE = "employees.txt";
    private static final String DEFAULT_BIN_FILE = "employees.dat";

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = inputInt(">> Nhập lựa chọn của bạn: ");
            switch (choice) {
                case 1 -> handleAddEmployee();
                case 2 -> handleUpdateEmployee();
                case 3 -> handleDeleteEmployee();
                case 4 -> handleFindById();
                case 5 -> handleFindByType();
                case 6 -> handleShowAll();
                case 7 -> handleSaveToTextFile();
                case 8 -> handleLoadFromTextFile();
                case 9 -> handleSaveToBinaryFile();
                case 10 -> handleLoadFromBinaryFile();
                case 0 -> System.out.println(">> Đã thoát chương trình. Tạm biệt!");
                default -> System.out.println(">> Lựa chọn không hợp lệ! Vui lòng chọn lại.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("==================================================");
        System.out.println("        HỆ THỐNG QUẢN LÝ NHÂN VIÊN (OOP)         ");
        System.out.println("==================================================");
        System.out.println("1.  Thêm mới nhân viên (Experience / Fresher / Intern)");
        System.out.println("2.  Cập nhật thông tin nhân viên theo ID");
        System.out.println("3.  Xóa nhân viên theo ID");
        System.out.println("4.  Tìm kiếm nhân viên theo ID");
        System.out.println("5.  Tìm kiếm nhân viên theo loại (Experience, Fresher, Intern)");
        System.out.println("6.  Hiển thị toàn bộ nhân viên & tổng số lượng");
        System.out.println("----------------- ĐỌC / GHI FILE -----------------");
        System.out.println("7.  Ghi danh sách ra File Văn bản (.txt)");
        System.out.println("8.  Đọc danh sách từ File Văn bản (.txt)");
        System.out.println("9.  Ghi danh sách ra File Nhị phân (.dat - Serialization)");
        System.out.println("10. Đọc danh sách từ File Nhị phân (.dat - Serialization)");
        System.out.println("--------------------------------------------------");
        System.out.println("0.  Thoát chương trình");
        System.out.println("==================================================");
    }

    private static void handleAddEmployee() {
        System.out.println("\n--- CHỌN LOẠI NHÂN VIÊN CẦN THÊM ---");
        System.out.println("1. Nhân viên có kinh nghiệm (Experience)");
        System.out.println("2. Nhân viên mới tốt nghiệp (Fresher)");
        System.out.println("3. Thực tập sinh (Intern)");
        int typeChoice = inputInt(">> Chọn loại: ");

        if (typeChoice < 1 || typeChoice > 3) {
            System.out.println(">> Loại nhân viên không hợp lệ!");
            return;
        }

        String id = inputString("Nhập mã nhân viên (ID): ");
        String fullName = inputString("Nhập họ và tên: ");
        LocalDate birthDay = inputDate("Nhập ngày sinh (dd/MM/yyyy): ");
        String phone = inputString("Nhập số điện thoại: ");
        String email = inputString("Nhập email: ");

        List<Certificate> certificates = inputCertificates();

        Employee employee = switch (typeChoice) {
            case 1 -> {
                int expInYear = inputInt("Nhập số năm kinh nghiệm: ");
                String proSkill = inputString("Nhập kỹ năng chuyên môn: ");
                yield new Experience(id, fullName, birthDay, phone, email, certificates, expInYear, proSkill);
            }
            case 2 -> {
                LocalDate gradDate = inputDate("Nhập ngày tốt nghiệp (dd/MM/yyyy): ");
                String gradRank = inputString("Nhập xếp loại tốt nghiệp (Xuất sắc/Giỏi/Khá/...): ");
                String education = inputString("Nhập trường tốt nghiệp: ");
                yield new Fresher(id, fullName, birthDay, phone, email, certificates, gradDate, gradRank, education);
            }
            case 3 -> {
                String majors = inputString("Nhập chuyên ngành đang học: ");
                String semester = inputString("Nhập học kỳ đang học: ");
                String universityName = inputString("Nhập tên trường đại học: ");
                yield new Intern(id, fullName, birthDay, phone, email, certificates, majors, semester, universityName);
            }
            default -> null;
        };

        if (employee != null) {
            controller.addEmployee(employee);
        }
    }

    private static void handleUpdateEmployee() {
        String id = inputString("Nhập mã ID nhân viên cần sửa: ");
        Employee existing = controller.findEmployeeById(id);
        if (existing == null) {
            System.out.println(">> Không tìm thấy nhân viên với ID: " + id);
            return;
        }

        System.out.println(">> Tìm thấy nhân viên: ");
        existing.showInfo();

        System.out.println("\n--- NHẬP THÔNG TIN MỚI ---");
        String fullName = inputString("Nhập họ và tên mới: ");
        LocalDate birthDay = inputDate("Nhập ngày sinh mới (dd/MM/yyyy): ");
        String phone = inputString("Nhập số điện thoại mới: ");
        String email = inputString("Nhập email mới: ");
        List<Certificate> certificates = inputCertificates();

        Employee updatedEmployee = null;
        if (existing instanceof Experience) {
            int expInYear = inputInt("Nhập số năm kinh nghiệm mới: ");
            String proSkill = inputString("Nhập kỹ năng chuyên môn mới: ");
            updatedEmployee = new Experience(id, fullName, birthDay, phone, email, certificates, expInYear, proSkill);
        } else if (existing instanceof Fresher) {
            LocalDate gradDate = inputDate("Nhập ngày tốt nghiệp mới (dd/MM/yyyy): ");
            String gradRank = inputString("Nhập xếp loại tốt nghiệp mới: ");
            String education = inputString("Nhập trường tốt nghiệp mới: ");
            updatedEmployee = new Fresher(id, fullName, birthDay, phone, email, certificates, gradDate, gradRank, education);
        } else if (existing instanceof Intern) {
            String majors = inputString("Nhập chuyên ngành mới: ");
            String semester = inputString("Nhập học kỳ mới: ");
            String universityName = inputString("Nhập trường đại học mới: ");
            updatedEmployee = new Intern(id, fullName, birthDay, phone, email, certificates, majors, semester, universityName);
        }

        if (updatedEmployee != null) {
            controller.updateEmployee(id, updatedEmployee);
        }
    }

    private static void handleDeleteEmployee() {
        String id = inputString("Nhập mã ID nhân viên cần xóa: ");
        controller.deleteEmployee(id);
    }

    private static void handleFindById() {
        String id = inputString("Nhập mã ID nhân viên cần tìm: ");
        Employee employee = controller.findEmployeeById(id);
        if (employee != null) {
            System.out.println(">> KẾT QUẢ TÌM THẤY:");
            employee.showInfo();
        } else {
            System.out.println(">> Không tìm thấy nhân viên có ID: " + id);
        }
    }

    private static void handleFindByType() {
        System.out.println("\n--- CHỌN LOẠI NHÂN VIÊN ĐỂ TÌM KIẾM ---");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Intern");
        int typeChoice = inputInt(">> Chọn loại: ");

        EmployeeType type = switch (typeChoice) {
            case 1 -> EmployeeType.EXPERIENCE;
            case 2 -> EmployeeType.FRESHER;
            case 3 -> EmployeeType.INTERN;
            default -> null;
        };

        if (type == null) {
            System.out.println(">> Loại nhân viên không hợp lệ!");
            return;
        }

        List<Employee> list = controller.findEmployeesByType(type);
        if (list.isEmpty()) {
            System.out.println(">> Không có nhân viên nào thuộc loại này!");
        } else {
            System.out.println(">> DANH SÁCH NHÂN VIÊN (" + list.size() + " người):");
            list.forEach(Employee::showInfo);
        }
    }

    private static void handleShowAll() {
        List<Employee> employees = controller.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println(">> Danh sách nhân viên đang trống!");
        } else {
            System.out.println(">> TOÀN BỘ DANH SÁCH NHÂN VIÊN:");
            employees.forEach(Employee::showInfo);
        }
        System.out.println(">> Tổng số lượng nhân viên hiện tại trong hệ thống: " + controller.getEmployeeCount());
    }

    private static void handleSaveToTextFile() {
        String path = inputString("Nhập tên file text cần lưu (Nhấn Enter để dùng '" + DEFAULT_TEXT_FILE + "'): ");
        if (path.isEmpty()) {
            path = DEFAULT_TEXT_FILE;
        }
        controller.saveToTextFile(path);
    }

    private static void handleLoadFromTextFile() {
        String path = inputString("Nhập tên file text cần đọc (Nhấn Enter để dùng '" + DEFAULT_TEXT_FILE + "'): ");
        if (path.isEmpty()) {
            path = DEFAULT_TEXT_FILE;
        }
        controller.loadFromTextFile(path);
    }

    private static void handleSaveToBinaryFile() {
        String path = inputString("Nhập tên file nhị phân cần lưu (Nhấn Enter để dùng '" + DEFAULT_BIN_FILE + "'): ");
        if (path.isEmpty()) {
            path = DEFAULT_BIN_FILE;
        }
        controller.saveToBinaryFile(path);
    }

    private static void handleLoadFromBinaryFile() {
        String path = inputString("Nhập tên file nhị phân cần đọc (Nhấn Enter để dùng '" + DEFAULT_BIN_FILE + "'): ");
        if (path.isEmpty()) {
            path = DEFAULT_BIN_FILE;
        }
        controller.loadFromBinaryFile(path);
    }

    private static List<Certificate> inputCertificates() {
        List<Certificate> certs = new ArrayList<>();
        int count = inputInt("Nhập số lượng bằng cấp/chứng chỉ (0 nếu không có): ");
        for (int i = 1; i <= count; i++) {
            System.out.println("--- Nhập bằng cấp #" + i + " ---");
            String certId = inputString("Mã chứng chỉ: ");
            String certName = inputString("Tên chứng chỉ: ");
            String certRank = inputString("Xếp loại chứng chỉ: ");
            LocalDate certDate = inputDate("Ngày cấp (dd/MM/yyyy): ");
            certs.add(new Certificate(certId, certName, certRank, certDate));
        }
        return certs;
    }

    private static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int inputInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(">> Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }

    private static LocalDate inputDate(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return LocalDate.parse(input, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println(">> Định dạng ngày không hợp lệ! Vui lòng nhập đúng dạng dd/MM/yyyy (ví dụ: 15/08/2000).");
            }
        }
    }
}
