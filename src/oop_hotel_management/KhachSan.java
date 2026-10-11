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
        // Kiá»ƒm tra xem khÃ¡ch cÃ³ sá»‘ CMND nÃ y Ä‘Ã£ Ä‘ang thuÃª phÃ²ng hay chÆ°a
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
        return null; // KhÃ´ng tÃ¬m tháº¥y
    }

    public void hienThiDanhSach() {
        if (danhSachKhachThue.isEmpty()) {
            System.out.println("Hiá»‡n táº¡i khÃ¡ch sáº¡n khÃ´ng cÃ³ khÃ¡ch Ä‘ang thuÃª phÃ²ng.");
            return;
        }
        System.out.println("----- DANH SÃCH KHÃCH THUÃŠ PHÃ’NG (" + danhSachKhachThue.size() + ") -----");
        for (int i = 0; i < danhSachKhachThue.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachKhachThue.get(i));
        }
    }

    public List<KhachThue> getDanhSachKhachThue() {
        return danhSachKhachThue;
    }
}
