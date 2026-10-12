package oop_officer_management;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QLCB qlcb = new QLCB();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== CHƯƠNG TRÌNH QUẢN LÝ CÁN BỘ (BÀI 1) ==========");
            System.out.println("1. Thêm mới cán bộ (Công nhân, Kỹ sư, Nhân viên)");
            System.out.println("2. Tìm kiếm cán bộ theo họ tên");
            System.out.println("3. Hiển thị thông tin danh sách cán bộ");
            System.out.println("0. Thoát khỏi chương trình");
            System.out.print(">> Nhập lựa chọn của bạn: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiCanBo();
                    break;
                case 2:
                    timKiemCanBo();
                    break;
                case 3:
                    qlcb.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình Quản lý cán bộ.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiCanBo() {
        System.out.println("\n--- Chọn loại cán bộ muốn thêm ---");
        System.out.println("1. Công nhân");
        System.out.println("2. Kỹ sư");
        System.out.println("3. Nhân viên");
        System.out.print(">> Lựa chọn: ");
        int loai;
        try {
            loai = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lựa chọn không hợp lệ!");
            return;
        }

        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nhập tuổi: ");
        int tuoi;
        try {
            tuoi = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tuổi phải là số nguyên!");
            return;
        }

        System.out.print("Nhập giới tính (Nam/Nữ/Khác): ");
        String gioiTinh = scanner.nextLine().trim();

        System.out.print("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine().trim();

        switch (loai) {
            case 1:
                System.out.print("Nhập bậc (1 - 10): ");
                int bac;
                try {
                    bac = Integer.parseInt(scanner.nextLine().trim());
                    if (bac < 1 || bac > 10) {
                        System.out.println("Bậc phải từ 1 đến 10!");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Bậc phải là số!");
                    return;
                }
                qlcb.themCanBo(new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac));
                System.out.println(">> Thêm công nhân thành công!");
                break;
            case 2:
                System.out.print("Nhập ngành đào tạo: ");
                String nganh = scanner.nextLine().trim();
                qlcb.themCanBo(new KySu(hoTen, tuoi, gioiTinh, diaChi, nganh));
                System.out.println(">> Thêm kỹ sư thành công!");
                break;
            case 3:
                System.out.print("Nhập công việc: ");
                String congViec = scanner.nextLine().trim();
                qlcb.themCanBo(new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec));
                System.out.println(">> Thêm nhân viên thành công!");
                break;
            default:
                System.out.println("Loại cán bộ không hợp lệ!");
        }
    }

    private static void timKiemCanBo() {
        System.out.print("Nhập họ tên cần tìm kiếm: ");
        String hoTen = scanner.nextLine().trim();
        List<CanBo> ketQua = qlcb.timKiemTheoHoTen(hoTen);
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy cán bộ nào có tên chứa: " + hoTen);
        } else {
            System.out.println("--- Kết quả tìm kiếm (" + ketQua.size() + ") ---");
            for (CanBo cb : ketQua) {
                System.out.println(cb);
            }
        }
    }
}
