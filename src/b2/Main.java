package b2;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuanLySach qls = new QuanLySach();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUẢN LÝ TÀI LIỆU THƯ VIỆN (BÀI 2) ==========");
            System.out.println("1. Thêm mới tài liệu (Sách, Tạp chí, Báo)");
            System.out.println("2. Xóa tài liệu theo mã tài liệu");
            System.out.println("3. Hiển thị thông tin toàn bộ tài liệu");
            System.out.println("4. Tìm kiếm tài liệu theo loại (Sách, Tạp chí, Báo)");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiTaiLieu();
                    break;
                case 2:
                    xoaTaiLieu();
                    break;
                case 3:
                    qls.hienThiThongTin();
                    break;
                case 4:
                    timKiemTaiLieuTheoLoai();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình Quản lý tài liệu.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiTaiLieu() {
        System.out.println("\n--- Chọn loại tài liệu cần thêm ---");
        System.out.println("1. Sách");
        System.out.println("2. Tạp chí");
        System.out.println("3. Báo");
        System.out.print(">> Lựa chọn: ");
        int loai;
        try {
            loai = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ!");
            return;
        }

        System.out.print("Nhập mã tài liệu: ");
        String maTL = scanner.nextLine().trim();

        System.out.print("Nhập tên nhà xuất bản: ");
        String nxb = scanner.nextLine().trim();

        System.out.print("Nhập số bản phát hành: ");
        int soBan;
        try {
            soBan = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Số bản phát hành phải là số nguyên!");
            return;
        }

        TaiLieu taiLieu;
        switch (loai) {
            case 1:
                System.out.print("Nhập tên tác giả: ");
                String tacGia = scanner.nextLine().trim();
                System.out.print("Nhập số trang: ");
                int soTrang;
                try {
                    soTrang = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Số trang phải là số nguyên!");
                    return;
                }
                taiLieu = new Sach(maTL, nxb, soBan, tacGia, soTrang);
                break;
            case 2:
                System.out.print("Nhập số phát hành: ");
                int soPhatHanh;
                try {
                    soPhatHanh = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Số phát hành phải là số nguyên!");
                    return;
                }
                System.out.print("Nhập tháng phát hành (1 - 12): ");
                int thangPhatHanh;
                try {
                    thangPhatHanh = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Tháng phát hành phải là số nguyên!");
                    return;
                }
                taiLieu = new TapChi(maTL, nxb, soBan, soPhatHanh, thangPhatHanh);
                break;
            case 3:
                System.out.print("Nhập ngày phát hành (1 - 31): ");
                int ngayPhatHanh;
                try {
                    ngayPhatHanh = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Ngày phát hành phải là số nguyên!");
                    return;
                }
                taiLieu = new Bao(maTL, nxb, soBan, ngayPhatHanh);
                break;
            default:
                System.out.println("Loại tài liệu không hợp lệ!");
                return;
        }

        boolean thanhCong = qls.themTaiLieu(taiLieu);
        if (thanhCong) {
            System.out.println(">> Thêm mới tài liệu thành công!");
        } else {
            System.out.println(">> Thất bại: Mã tài liệu '" + maTL + "' đã tồn tại trong hệ thống!");
        }
    }

    private static void xoaTaiLieu() {
        System.out.print("Nhập mã tài liệu cần xóa: ");
        String ma = scanner.nextLine().trim();
        boolean daXoa = qls.xoaTaiLieu(ma);
        if (daXoa) {
            System.out.println(">> Đã xóa thành công tài liệu có mã: " + ma);
        } else {
            System.out.println(">> Không tìm thấy tài liệu có mã: " + ma);
        }
    }

    private static void timKiemTaiLieuTheoLoai() {
        System.out.println("Chọn loại tài liệu cần tìm:");
        System.out.println("1. Sách");
        System.out.println("2. Tạp chí");
        System.out.println("3. Báo");
        System.out.print(">> Lựa chọn (1/2/3 hoặc tên loại): ");
        String loai = scanner.nextLine().trim();
        List<TaiLieu> ketQua = qls.timKiemTheoLoai(loai);
        if (ketQua.isEmpty()) {
            System.out.println("Không có tài liệu nào thuộc loại đã chọn.");
        } else {
            System.out.println("--- KẾT QUẢ TÌM KIẾM (" + ketQua.size() + ") ---");
            for (TaiLieu tl : ketQua) {
                System.out.println(tl);
            }
        }
    }
}
