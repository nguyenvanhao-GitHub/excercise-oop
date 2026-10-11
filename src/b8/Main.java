package b8;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuanLyTheMuon qltm = new QuanLyTheMuon();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUẢN LÝ MƯỢN TRẢ SÁCH (BÀI 8) ==========");
            System.out.println("1. Thêm mới thẻ mượn");
            System.out.println("2. Xóa thẻ mượn theo mã phiếu mượn");
            System.out.println("3. Hiển thị thông tin các thẻ mượn");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiTheMuon();
                    break;
                case 2:
                    xoaTheMuon();
                    break;
                case 3:
                    qltm.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình Quản lý mượn trả sách.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiTheMuon() {
        System.out.print("Nhập mã phiếu mượn: ");
        String maPhieu = scanner.nextLine().trim();

        System.out.print("Nhập họ tên sinh viên mượn sách: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nhập tuổi sinh viên: ");
        int tuoi;
        try {
            tuoi = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tuổi phải là số nguyên!");
            return;
        }

        System.out.print("Nhập lớp: ");
        String lop = scanner.nextLine().trim();

        System.out.print("Nhập số hiệu sách: ");
        String soHieuSach = scanner.nextLine().trim();

        System.out.print("Nhập ngày mượn (số nguyên dương): ");
        int ngayMuon;
        try {
            ngayMuon = Integer.parseInt(scanner.nextLine().trim());
            if (ngayMuon <= 0) {
                System.out.println("Ngày mượn phải là số nguyên dương!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ngày mượn phải là số nguyên!");
            return;
        }

        System.out.print("Nhập hạn trả (số nguyên dương): ");
        int hanTra;
        try {
            hanTra = Integer.parseInt(scanner.nextLine().trim());
            if (hanTra <= 0 || hanTra < ngayMuon) {
                System.out.println("Hạn trả phải là số nguyên dương và lớn hơn hoặc bằng ngày mượn!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Hạn trả phải là số nguyên!");
            return;
        }

        SinhVien sv = new SinhVien(hoTen, tuoi, lop);
        TheMuon theMuon = new TheMuon(maPhieu, ngayMuon, hanTra, soHieuSach, sv);

        boolean thanhCong = qltm.themTheMuon(theMuon);
        if (thanhCong) {
            System.out.println(">> Thêm mới thẻ mượn thành công!");
        } else {
            System.out.println(">> Thất bại: Mã phiếu mượn '" + maPhieu + "' đã tồn tại!");
        }
    }

    private static void xoaTheMuon() {
        System.out.print("Nhập mã phiếu mượn cần xóa: ");
        String ma = scanner.nextLine().trim();
        boolean daXoa = qltm.xoaTheMuon(ma);
        if (daXoa) {
            System.out.println(">> Đã xóa thành công thẻ mượn có mã: " + ma);
        } else {
            System.out.println(">> Không tìm thấy thẻ mượn có mã: " + ma);
        }
    }
}
