package oop_hotel_management;

import java.util.ArrayList;
import java.util.List;

public class KhachSan {
    private final List<KhachThue> danhSachKhachThue;

    public KhachSan() {
        this.danhSachKhachThue = new ArrayList<>();
    }

    public boolean themKhachThue(KhachThue khachThue) {
        if (khachThue == null || khachThue.getNguoi() == null) return false;
        // Kiểm tra xem khách có số CMND này đã đang thuê phòng hay chưa
        boolean tonTai = danhSachKhachThue.stream()
                .anyMatch(kt -> kt.getNguoi().getSoCMND().equalsIgnoreCase(khachThue.getNguoi().getSoCMND()));
        if (tonTai) {
            return false;
        }
        danhSachKhachThue.add(khachThue);
        return true;
    }

    public boolean xoaKhachThue(String soCMND) {
        if (soCMND == null || soCMND.trim().isEmpty()) return false;
        return danhSachKhachThue.removeIf(kt -> kt.getNguoi().getSoCMND().equalsIgnoreCase(soCMND.trim()));
    }

    public Double tinhTienThuePhong(String soCMND) {
        if (soCMND == null || soCMND.trim().isEmpty()) return null;
        for (KhachThue kt : danhSachKhachThue) {
            if (kt.getNguoi().getSoCMND().equalsIgnoreCase(soCMND.trim())) {
                return kt.tinhTien();
            }
        }
        return null; // Không tìm thấy
    }

    public void hienThiDanhSach() {
        if (danhSachKhachThue.isEmpty()) {
            System.out.println("Hiện tại khách sạn không có khách đang thuê phòng.");
            return;
        }
        System.out.println("----- DANH SÁCH KHÁCH THUÊ PHÒNG (" + danhSachKhachThue.size() + ") -----");
        for (int i = 0; i < danhSachKhachThue.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachKhachThue.get(i));
        }
    }

    public List<KhachThue> getDanhSachKhachThue() {
        return danhSachKhachThue;
    }
}
