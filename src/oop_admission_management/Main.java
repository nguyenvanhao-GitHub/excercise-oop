package oop_admission_management;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TuyenSinh tuyenSinh = new TuyenSinh();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUẢN LÝ TUYỂN SINH ĐẠI HỌC (BÀI 3) ==========");
            System.out.println("1. Thêm mới thí sinh (Khối A, Khối B, Khối C)");
            System.out.println("2. Hiển thị thông tin và khối thi của thí sinh");
            System.out.println("3. Tìm kiếm thí sinh theo số báo danh");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiThiSinh();
                    break;
                case 2:
                    tuyenSinh.hienThiThongTin();
                    break;
                case 3:
                    timKiemThiSinh();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình Quản lý tuyển sinh.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiThiSinh() {
        System.out.println("\n--- Chọn khối thi ---");
        System.out.println("1. Khối A (Toán, Lý, Hoá)");
        System.out.println("2. Khối B (Toán, Hoá, Sinh)");
        System.out.println("3. Khối C (Văn, Sử, Địa)");
        System.out.print(">> Lựa chọn: ");
        int loai;
        try {
            loai = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ!");
            return;
        }

        System.out.print("Nhập số báo danh: ");
        String sbd = scanner.nextLine().trim();

        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine().trim();

        System.out.print("Nhập mức ưu tiên: ");
        int mucUuTien;
        try {
            mucUuTien = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Mức ưu tiên phải là số nguyên!");
            return;
        }

        ThiSinh thiSinh;
        switch (loai) {
            case 1:
                thiSinh = new ThiSinhKhoiA(sbd, hoTen, diaChi, mucUuTien);
                break;
            case 2:
                thiSinh = new ThiSinhKhoiB(sbd, hoTen, diaChi, mucUuTien);
                break;
            case 3:
                thiSinh = new ThiSinhKhoiC(sbd, hoTen, diaChi, mucUuTien);
                break;
            default:
                System.out.println("Khối thi không hợp lệ!");
                return;
        }

        boolean thanhCong = tuyenSinh.themThiSinh(thiSinh);
        if (thanhCong) {
            System.out.println(">> Thêm mới thí sinh thành công!");
        } else {
            System.out.println(">> Thất bại: Số báo danh '" + sbd + "' đã tồn tại!");
        }
    }

    private static void timKiemThiSinh() {
        System.out.print("Nhập số báo danh cần tìm: ");
        String sbd = scanner.nextLine().trim();
        ThiSinh thiSinh = tuyenSinh.timKiemTheoSoBaoDanh(sbd);
        if (thiSinh != null) {
            System.out.println(">> Đã tìm thấy thí sinh:");
            System.out.println(thiSinh);
        } else {
            System.out.println(">> Không tìm thấy thí sinh có số báo danh: " + sbd);
        }
    }
}
