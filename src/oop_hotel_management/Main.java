package oop_hotel_management;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final KhachSan khachSan = new KhachSan();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUẢN LÝ KHÁCH SẠN (BÀI 5) ==========");
            System.out.println("1. Thêm mới khách thuê phòng");
            System.out.println("2. Xóa khách thuê theo số CMND");
            System.out.println("3. Tính tiền thuê phòng theo số CMND");
            System.out.println("4. Hiển thị danh sách khách thuê phòng");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiKhachThue();
                    break;
                case 2:
                    xoaKhachThue();
                    break;
                case 3:
                    tinhTienThue();
                    break;
                case 4:
                    khachSan.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình Quản lý khách sạn.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiKhachThue() {
        System.out.print("Nhập họ tên khách hàng: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nhập tuổi: ");
        int tuoi;
        try {
            tuoi = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tuổi phải là số nguyên!");
            return;
        }

        System.out.print("Nhập số CMND: ");
        String cmnd = scanner.nextLine().trim();

        System.out.println("Chọn loại phòng thuê:");
        System.out.println("1. Loại A (500$/ngày)");
        System.out.println("2. Loại B (300$/ngày)");
        System.out.println("3. Loại C (100$/ngày)");
        System.out.print(">> Chọn loại phòng (1/2/3 hoặc A/B/C): ");
        String chonPhong = scanner.nextLine().trim().toUpperCase();

        Phong phong;
        if (chonPhong.equals("1") || chonPhong.equals("A")) {
            phong = new PhongA();
        } else if (chonPhong.equals("2") || chonPhong.equals("B")) {
            phong = new PhongB();
        } else if (chonPhong.equals("3") || chonPhong.equals("C")) {
            phong = new PhongC();
        } else {
            System.out.println("Loại phòng không hợp lệ!");
            return;
        }

        System.out.print("Nhập số ngày thuê: ");
        int soNgay;
        try {
            soNgay = Integer.parseInt(scanner.nextLine().trim());
            if (soNgay <= 0) {
                System.out.println("Số ngày thuê phải lớn hơn 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Số ngày thuê phải là số nguyên!");
            return;
        }

        Nguoi nguoi = new Nguoi(hoTen, tuoi, cmnd);
        KhachThue khachThue = new KhachThue(nguoi, phong, soNgay);

        boolean thanhCong = khachSan.themKhachThue(khachThue);
        if (thanhCong) {
            System.out.println(">> Thêm mới khách thuê thành công!");
        } else {
            System.out.println(">> Thất bại: Khách hàng với số CMND '" + cmnd + "' đang thuê phòng!");
        }
    }

    private static void xoaKhachThue() {
        System.out.print("Nhập số CMND khách cần trả phòng/xóa: ");
        String cmnd = scanner.nextLine().trim();
        boolean daXoa = khachSan.xoaKhachThue(cmnd);
        if (daXoa) {
            System.out.println(">> Đã xóa khách hàng có số CMND: " + cmnd);
        } else {
            System.out.println(">> Không tìm thấy khách hàng có số CMND: " + cmnd);
        }
    }

    private static void tinhTienThue() {
        System.out.print("Nhập số CMND của khách để thanh toán: ");
        String cmnd = scanner.nextLine().trim();
        Double tongTien = khachSan.tinhTienThuePhong(cmnd);
        if (tongTien != null) {
            System.out.println(">> Tổng tiền thuê phòng của khách hàng [CMND: " + cmnd + "] là: " + tongTien + " $");
        } else {
            System.out.println(">> Không tìm thấy khách hàng có số CMND: " + cmnd);
        }
    }
}
