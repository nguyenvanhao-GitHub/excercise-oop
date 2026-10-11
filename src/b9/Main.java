package b9;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuanLyBienLai qlbl = new QuanLyBienLai();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUẢN LÝ BIÊN LAI THU TIỀN ĐIỆN (BÀI 9) ==========");
            System.out.println("1. Thêm mới hộ sử dụng điện & biên lai");
            System.out.println("2. Sửa thông tin hộ sử dụng điện theo mã công tơ");
            System.out.println("3. Xóa hộ sử dụng điện theo mã công tơ");
            System.out.println("4. Hiển thị danh sách biên lai và số tiền điện phải trả");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiBienLai();
                    break;
                case 2:
                    suaThongTin();
                    break;
                case 3:
                    xoaBienLai();
                    break;
                case 4:
                    qlbl.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình Quản lý biên lai điện.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiBienLai() {
        System.out.print("Nhập mã số công tơ điện: ");
        String maCongTo = scanner.nextLine().trim();

        System.out.print("Nhập họ tên chủ hộ: ");
        String chuHo = scanner.nextLine().trim();

        System.out.print("Nhập số nhà: ");
        String soNha = scanner.nextLine().trim();

        System.out.print("Nhập chỉ số điện cũ: ");
        double chiSoCu;
        try {
            chiSoCu = Double.parseDouble(scanner.nextLine().trim());
            if (chiSoCu < 0) {
                System.out.println("Chỉ số điện không được âm!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Chỉ số điện cũ phải là số!");
            return;
        }

        System.out.print("Nhập chỉ số điện mới: ");
        double chiSoMoi;
        try {
            chiSoMoi = Double.parseDouble(scanner.nextLine().trim());
            if (chiSoMoi < chiSoCu) {
                System.out.println("Chỉ số điện mới phải lớn hơn hoặc bằng chỉ số cũ!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Chỉ số điện mới phải là số!");
            return;
        }

        KhachHang kh = new KhachHang(chuHo, soNha, maCongTo);
        BienLai bl = new BienLai(kh, chiSoCu, chiSoMoi);

        boolean thanhCong = qlbl.themBienLai(bl);
        if (thanhCong) {
            System.out.println(">> Thêm biên lai thành công! Tiền điện phải trả: " +
                    String.format("%,.2f", bl.tinhTienDien()) + " VNĐ");
        } else {
            System.out.println(">> Thất bại: Mã công tơ '" + maCongTo + "' đã tồn tại!");
        }
    }

    private static void suaThongTin() {
        System.out.print("Nhập mã công tơ cần sửa thông tin: ");
        String ma = scanner.nextLine().trim();

        System.out.print("Nhập họ tên chủ hộ mới (bỏ trống nếu không đổi): ");
        String tenMoi = scanner.nextLine().trim();

        System.out.print("Nhập số nhà mới (bỏ trống nếu không đổi): ");
        String soNhaMoi = scanner.nextLine().trim();

        boolean daSua = qlbl.suaThongTinKhachHang(ma, tenMoi, soNhaMoi);
        if (daSua) {
            System.out.println(">> Sửa thông tin thành công cho mã công tơ: " + ma);
        } else {
            System.out.println(">> Không tìm thấy hộ có mã công tơ: " + ma);
        }
    }

    private static void xoaBienLai() {
        System.out.print("Nhập mã công tơ cần xóa: ");
        String ma = scanner.nextLine().trim();
        boolean daXoa = qlbl.xoaBienLai(ma);
        if (daXoa) {
            System.out.println(">> Đã xóa biên lai có mã công tơ: " + ma);
        } else {
            System.out.println(">> Không tìm thấy hộ có mã công tơ: " + ma);
        }
    }
}
