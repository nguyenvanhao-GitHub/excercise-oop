package oop_school_management;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuanLyHocSinh qlhs = new QuanLyHocSinh();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUẢN LÝ HỒ SƠ HỌC SINH THPT (BÀI 6) ==========");
            System.out.println("1. Thêm học sinh mới");
            System.out.println("2. Hiển thị toàn bộ danh sách học sinh");
            System.out.println("3. Hiển thị các học sinh 20 tuổi");
            System.out.println("4. Đếm số lượng học sinh 23 tuổi và quê ở DN");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themHocSinhMoi();
                    break;
                case 2:
                    qlhs.hienThiDanhSach();
                    break;
                case 3:
                    hienThiHocSinh20Tuoi();
                    break;
                case 4:
                    demHocSinh23TuoiDN();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình Quản lý học sinh.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }

    private static void themHocSinhMoi() {
        System.out.print("Nhập họ tên học sinh: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nhập tuổi: ");
        int tuoi;
        try {
            tuoi = Integer.parseInt(scanner.nextLine().trim());
            if (tuoi <= 0) {
                System.out.println("Tuổi phải lớn hơn 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Tuổi phải là số nguyên!");
            return;
        }

        System.out.print("Nhập quê quán: ");
        String queQuan = scanner.nextLine().trim();

        System.out.print("Nhập lớp: ");
        String lop = scanner.nextLine().trim();

        qlhs.themHocSinh(new HocSinh(hoTen, tuoi, queQuan, lop));
        System.out.println(">> Thêm học sinh thành công!");
    }

    private static void hienThiHocSinh20Tuoi() {
        List<HocSinh> ds20 = qlhs.timHocSinh20Tuoi();
        if (ds20.isEmpty()) {
            System.out.println("Không có học sinh nào 20 tuổi.");
        } else {
            System.out.println("----- DANH SÁCH HỌC SINH 20 TUỔI (" + ds20.size() + ") -----");
            for (HocSinh hs : ds20) {
                System.out.println(hs);
            }
        }
    }

    private static void demHocSinh23TuoiDN() {
        long dem = qlhs.demHocSinh23TuoiQueDN();
        System.out.println(">> Số lượng học sinh 23 tuổi và có quê ở DN (Đà Nẵng): " + dem);
    }
}
