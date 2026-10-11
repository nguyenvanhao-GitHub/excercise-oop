package b12;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QLPTGT qlptgt = new QLPTGT();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG (BÀI 12) ==========");
            System.out.println("1. Thêm mới phương tiện (Ô tô, Xe máy, Xe tải)");
            System.out.println("2. Xóa phương tiện theo ID");
            System.out.println("3. Tìm phương tiện theo hãng sản xuất");
            System.out.println("4. Tìm phương tiện theo màu xe");
            System.out.println("5. Hiển thị danh sách phương tiện");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiPhuongTien();
                    break;
                case 2:
                    xoaPhuongTien();
                    break;
                case 3:
                    timTheoHangSX();
                    break;
                case 4:
                    timTheoMauXe();
                    break;
                case 5:
                    qlptgt.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình Quản lý phương tiện giao thông.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiPhuongTien() {
        System.out.println("\n--- Chọn loại phương tiện ---");
        System.out.println("1. Ô tô");
        System.out.println("2. Xe máy");
        System.out.println("3. Xe tải");
        System.out.print(">> Lựa chọn: ");
        int loai;
        try {
            loai = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ!");
            return;
        }

        System.out.print("Nhập ID phương tiện: ");
        String id = scanner.nextLine().trim();

        System.out.print("Nhập hãng sản xuất: ");
        String hangSX = scanner.nextLine().trim();

        System.out.print("Nhập năm sản xuất: ");
        int namSX;
        try {
            namSX = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Năm sản xuất phải là số nguyên!");
            return;
        }

        System.out.print("Nhập giá bán: ");
        double giaBan;
        try {
            giaBan = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Giá bán phải là số!");
            return;
        }

        System.out.print("Nhập màu xe: ");
        String mauXe = scanner.nextLine().trim();

        PhuongTien pt;
        switch (loai) {
            case 1:
                System.out.print("Nhập số chỗ ngồi: ");
                int soCho;
                try {
                    soCho = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Số chỗ ngồi phải là số nguyên!");
                    return;
                }
                System.out.print("Nhập kiểu động cơ: ");
                String dongCo = scanner.nextLine().trim();
                pt = new Oto(id, hangSX, namSX, giaBan, mauXe, soCho, dongCo);
                break;
            case 2:
                System.out.print("Nhập công suất (HP): ");
                double congSuat;
                try {
                    congSuat = Double.parseDouble(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Công suất phải là số!");
                    return;
                }
                pt = new XeMay(id, hangSX, namSX, giaBan, mauXe, congSuat);
                break;
            case 3:
                System.out.print("Nhập trọng tải (tấn): ");
                double trongTai;
                try {
                    trongTai = Double.parseDouble(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Trọng tải phải là số!");
                    return;
                }
                pt = new XeTai(id, hangSX, namSX, giaBan, mauXe, trongTai);
                break;
            default:
                System.out.println("Loại phương tiện không hợp lệ!");
                return;
        }

        boolean thanhCong = qlptgt.themPhuongTien(pt);
        if (thanhCong) {
            System.out.println(">> Thêm mới phương tiện thành công!");
        } else {
            System.out.println(">> Thất bại: ID '" + id + "' đã tồn tại trong hệ thống!");
        }
    }

    private static void xoaPhuongTien() {
        System.out.print("Nhập ID phương tiện cần xóa: ");
        String id = scanner.nextLine().trim();
        boolean daXoa = qlptgt.xoaPhuongTien(id);
        if (daXoa) {
            System.out.println(">> Đã xóa thành công phương tiện có ID: " + id);
        } else {
            System.out.println(">> Không tìm thấy phương tiện có ID: " + id);
        }
    }

    private static void timTheoHangSX() {
        System.out.print("Nhập hãng sản xuất cần tìm: ");
        String hang = scanner.nextLine().trim();
        List<PhuongTien> ketQua = qlptgt.timKiemTheoHangSanXuat(hang);
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy phương tiện nào của hãng: " + hang);
        } else {
            System.out.println("--- KẾT QUẢ TÌM KIẾM THEO HÃNG (" + ketQua.size() + ") ---");
            for (PhuongTien p : ketQua) {
                System.out.println(p);
            }
        }
    }

    private static void timTheoMauXe() {
        System.out.print("Nhập màu xe cần tìm: ");
        String mau = scanner.nextLine().trim();
        List<PhuongTien> ketQua = qlptgt.timKiemTheoMau(mau);
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy phương tiện nào có màu: " + mau);
        } else {
            System.out.println("--- KẾT QUẢ TÌM KIẾM THEO MÀU (" + ketQua.size() + ") ---");
            for (PhuongTien p : ketQua) {
                System.out.println(p);
            }
        }
    }
}
