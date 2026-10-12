package oop_teacher_salary_management;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuanLyCBGV quanLy = new QuanLyCBGV();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUẢN LÝ LƯƠNG CÁN BỘ GIÁO VIÊN (BÀI 7) ==========");
            System.out.println("1. Thêm cán bộ giáo viên");
            System.out.println("2. Xóa cán bộ giáo viên theo mã số GV");
            System.out.println("3. Hiển thị danh sách cán bộ giáo viên & lương thực lĩnh");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themCBGV();
                    break;
                case 2:
                    xoaCBGV();
                    break;
                case 3:
                    quanLy.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình Quản lý lương cán bộ giáo viên.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }

    private static void themCBGV() {
        System.out.print("Nhập mã số giáo viên: ");
        String msgv = scanner.nextLine().trim();

        System.out.print("Nhập họ tên giáo viên: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nhập tuổi: ");
        int tuoi;
        try {
            tuoi = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tuổi phải là số nguyên!");
            return;
        }

        System.out.print("Nhập quê quán: ");
        String queQuan = scanner.nextLine().trim();

        System.out.print("Nhập lương cứng: ");
        double luongCung;
        try {
            luongCung = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lương cứng phải là số!");
            return;
        }

        System.out.print("Nhập lương thưởng: ");
        double luongThuong;
        try {
            luongThuong = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lương thưởng phải là số!");
            return;
        }

        System.out.print("Nhập tiền phạt: ");
        double tienPhat;
        try {
            tienPhat = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tiền phạt phải là số!");
            return;
        }

        CBGV cbgv = new CBGV(hoTen, tuoi, queQuan, msgv, luongCung, luongThuong, tienPhat);
        boolean thanhCong = quanLy.themCBGV(cbgv);
        if (thanhCong) {
            System.out.println(">> Thêm cán bộ giáo viên thành công!");
        } else {
            System.out.println(">> Thất bại: Mã số giáo viên '" + msgv + "' đã tồn tại!");
        }
    }

    private static void xoaCBGV() {
        System.out.print("Nhập mã số giáo viên cần xóa: ");
        String msgv = scanner.nextLine().trim();
        boolean daXoa = quanLy.xoaCBGV(msgv);
        if (daXoa) {
            System.out.println(">> Đã xóa cán bộ giáo viên có mã số: " + msgv);
        } else {
            System.out.println(">> Không tìm thấy cán bộ giáo viên có mã số: " + msgv);
        }
    }
}
