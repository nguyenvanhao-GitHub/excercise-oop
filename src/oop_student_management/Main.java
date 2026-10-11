package oop_student_management;

import oop_student_management.entity.GoodStudent;
import oop_student_management.entity.NormalStudent;
import oop_student_management.entity.Student;
import oop_student_management.exception.InvalidDOBException;
import oop_student_management.exception.InvalidFullNameException;
import oop_student_management.exception.InvalidPhoneNumberException;
import oop_student_management.service.StudentManager;
import oop_student_management.validator.StudentValidator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        initSampleData(); // Nạp sẵn danh sách mẫu sinh viên để thuận tiện kiểm thử tuyển chọn 11-15 người

        int choice;
        do {
            System.out.println("\n========== QUẢN LÝ TUYỂN DỤNG SINH VIÊN (BÀI 14) ==========");
            System.out.println("1. Thêm mới sinh viên khá/giỏi (GoodStudent)");
            System.out.println("2. Thêm mới sinh viên trung bình (NormalStudent)");
            System.out.println("3. Xét tuyển ứng viên vào công ty (Chỉ tiêu: 11 - 15 ứng viên)");
            System.out.println("4. Hiển thị danh sách sinh viên (Sắp xếp: Tên giảm dần, SĐT tăng dần)");
            System.out.println("5. Hiển thị toàn bộ thông tin chi tiết (ShowMyInfor)");
            System.out.println("0. Thoát chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            try {
                switch (choice) {
                    case 1 -> addGoodStudent();
                    case 2 -> addNormalStudent();
                    case 3 -> recruitCandidates();
                    case 4 -> manager.displayAllSortedByNameAndPhone();
                    case 5 -> showAllDetails();
                    case 0 -> System.out.println(">> Đã thoát chương trình Tuyển dụng sinh viên.");
                    default -> System.out.println(">> Lựa chọn không hợp lệ, vui lòng thử lại!");
                }
            } catch (InvalidFullNameException e) {
                System.err.println("Lỗi họ tên: " + e.getMessage());
            } catch (InvalidDOBException e) {
                System.err.println("Lỗi ngày sinh: " + e.getMessage());
            } catch (InvalidPhoneNumberException e) {
                System.err.println("Lỗi số điện thoại: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Input files have unknow errors !!!");
            }
        } while (choice != 0);
    }

    private static void addGoodStudent() {
        System.out.println("\n--- THÊM SINH VIÊN KHÁ / GIỎI ---");
        System.out.print("Nhập họ tên (10 - 50 ký tự): ");
        String fullName = scanner.nextLine().trim();
        StudentValidator.validateFullName(fullName);

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String dobStr = scanner.nextLine().trim();
        LocalDate doB = StudentValidator.validateDoB(dobStr);

        System.out.print("Nhập giới tính (Nam/Nữ): ");
        String sex = scanner.nextLine().trim();

        System.out.print("Nhập số điện thoại (10 chữ số, bắt đầu: 090, 098, 091, 031, 035, 038): ");
        String phone = scanner.nextLine().trim();
        StudentValidator.validatePhoneNumber(phone);

        System.out.print("Nhập tên trường đại học: ");
        String university = scanner.nextLine().trim();

        System.out.print("Nhập điểm GPA (thang 10): ");
        double gpa = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Nhập tên học bổng / giải thưởng cao nhất: ");
        String bestReward = scanner.nextLine().trim();

        GoodStudent gs = new GoodStudent(fullName, doB, sex, phone, university, "KhaGioi", gpa, bestReward);
        manager.addStudent(gs);
        System.out.println(">> Thêm sinh viên khá/giỏi thành công!");
    }

    private static void addNormalStudent() {
        System.out.println("\n--- THÊM SINH VIÊN TRUNG BÌNH ---");
        System.out.print("Nhập họ tên (10 - 50 ký tự): ");
        String fullName = scanner.nextLine().trim();
        StudentValidator.validateFullName(fullName);

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String dobStr = scanner.nextLine().trim();
        LocalDate doB = StudentValidator.validateDoB(dobStr);

        System.out.print("Nhập giới tính (Nam/Nữ): ");
        String sex = scanner.nextLine().trim();

        System.out.print("Nhập số điện thoại (10 chữ số, bắt đầu: 090, 098, 091, 031, 035, 038): ");
        String phone = scanner.nextLine().trim();
        StudentValidator.validatePhoneNumber(phone);

        System.out.print("Nhập tên trường đại học: ");
        String university = scanner.nextLine().trim();

        System.out.print("Nhập điểm TOEIC (englishScore): ");
        int englishScore = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Nhập điểm thi chuyên môn (entryTestScore thang 10): ");
        double entryTestScore = Double.parseDouble(scanner.nextLine().trim());

        NormalStudent ns = new NormalStudent(fullName, doB, sex, phone, university, "TrungBinh", englishScore, entryTestScore);
        manager.addStudent(ns);
        System.out.println(">> Thêm sinh viên trung bình thành công!");
    }

    private static void recruitCandidates() {
        System.out.print("Nhập số lượng sinh viên cần tuyển dụng (11 đến 15 người): ");
        int needed = Integer.parseInt(scanner.nextLine().trim());

        List<Student> recruited = manager.recruitCandidates(needed);
        System.out.println("\n=======================================================");
        System.out.println(" KẾT QUẢ TUYỂN DỤNG CÔNG TY (" + recruited.size() + "/" + needed + " ỨNG VIÊN)");
        System.out.println("=======================================================");
        for (int i = 0; i < recruited.size(); i++) {
            System.out.print((i + 1) + ". ");
            recruited.get(i).ShowMyInfor();
        }
    }

    private static void showAllDetails() {
        List<Student> list = manager.getStudents();
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("\n--- CHI TIẾT TẤT CẢ SINH VIÊN TRONG HỆ THỐNG ---");
        for (Student s : list) {
            s.ShowMyInfor();
        }
    }

    private static void initSampleData() {
        // Sinh viên Khá Giỏi (8 người)
        manager.addStudent(new GoodStudent("Nguyễn Văn An", LocalDate.of(2002, 5, 12), "Nam", "0901234561", "ĐH Bách Khoa", "KhaGioi", 9.2, "Thủ khoa đầu ra"));
        manager.addStudent(new GoodStudent("Trần Thị Bình", LocalDate.of(2002, 8, 20), "Nữ", "0981234562", "ĐH Quốc Gia", "KhaGioi", 8.8, "Học bổng Xuất sắc Odon Vallet"));
        manager.addStudent(new GoodStudent("Lê Hoàng Cường", LocalDate.of(2001, 11, 3), "Nam", "0911234563", "ĐH Sư Phạm Kỹ Thuật", "KhaGioi", 8.8, "Giải Nhất Olympic Toán"));
        manager.addStudent(new GoodStudent("Phạm Minh Dũng", LocalDate.of(2002, 1, 15), "Nam", "0351234564", "ĐH Công Nghệ", "KhaGioi", 8.5, "Học bổng Khuyến khích"));
        manager.addStudent(new GoodStudent("Hoàng Thu Giang", LocalDate.of(2002, 9, 9), "Nữ", "0381234565", "ĐH Ngoại Thương", "KhaGioi", 9.5, "Học bổng Toàn phần"));
        manager.addStudent(new GoodStudent("Đặng Hải Nam", LocalDate.of(2002, 3, 25), "Nam", "0311234566", "ĐH Bách Khoa", "KhaGioi", 8.0, "Giải Ba Nghiên cứu khoa học"));
        manager.addStudent(new GoodStudent("Vũ Khánh Linh", LocalDate.of(2002, 7, 14), "Nữ", "0909876541", "ĐH Quốc Gia", "KhaGioi", 7.9, "Học bổng Doanh nghiệp"));
        manager.addStudent(new GoodStudent("Ngô Bảo Long", LocalDate.of(2001, 12, 30), "Nam", "0988765432", "ĐH Bách Khoa", "KhaGioi", 8.5, "Giải Nhì Tin học sinh viên"));

        // Sinh viên Trung Bình (8 người)
        manager.addStudent(new NormalStudent("Bùi Quang Huy", LocalDate.of(2002, 4, 18), "Nam", "0918765433", "ĐH Công Nghiệp", "TrungBinh", 750, 8.5));
        manager.addStudent(new NormalStudent("Đỗ Quỳnh Mai", LocalDate.of(2002, 6, 22), "Nữ", "0358765434", "ĐH Giao Thông Vận Tải", "TrungBinh", 650, 9.0));
        manager.addStudent(new NormalStudent("Dương Tuấn Kiệt", LocalDate.of(2002, 10, 5), "Nam", "0388765435", "ĐH Xây Dựng", "TrungBinh", 800, 7.5));
        manager.addStudent(new NormalStudent("Lý Mỹ Duyên", LocalDate.of(2002, 2, 14), "Nữ", "0318765436", "ĐH Kinh Tế Quốc Dân", "TrungBinh", 600, 8.0));
        manager.addStudent(new NormalStudent("Phan Trọng Nghĩa", LocalDate.of(2001, 8, 19), "Nam", "0903334441", "ĐH Mở", "TrungBinh", 700, 8.0));
        manager.addStudent(new NormalStudent("Tô Đình Trọng", LocalDate.of(2002, 11, 28), "Nam", "0984445552", "ĐH Thủy Lợi", "TrungBinh", 550, 7.0));
        manager.addStudent(new NormalStudent("Chu Diệu Linh", LocalDate.of(2002, 12, 1), "Nữ", "0915556663", "ĐH Thương Mại", "TrungBinh", 850, 9.0));
        manager.addStudent(new NormalStudent("Hà Đức Thắng", LocalDate.of(2001, 7, 7), "Nam", "0356667774", "ĐH Bưu Chính Viễn Thông", "TrungBinh", 650, 6.5));
    }
}
