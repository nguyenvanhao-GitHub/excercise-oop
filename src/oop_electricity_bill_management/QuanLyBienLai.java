package oop_electricity_bill_management;

import java.util.ArrayList;
import java.util.List;

public class QuanLyBienLai {
    private final List<BienLai> danhSachBienLai;

    public QuanLyBienLai() {
        this.danhSachBienLai = new ArrayList<>();
    }

    public boolean themBienLai(BienLai bl) {
        if (bl == null || bl.getKhachHang() == null) return false;
        boolean tonTai = danhSachBienLai.stream()
                .anyMatch(item -> item.getKhachHang().getMaSoCongTo().equalsIgnoreCase(bl.getKhachHang().getMaSoCongTo()));
        if (tonTai) {
            return false;
        }
        danhSachBienLai.add(bl);
        return true;
    }

    public boolean suaThongTinKhachHang(String maSoCongTo, String tenMoi, String soNhaMoi) {
        if (maSoCongTo == null || maSoCongTo.trim().isEmpty()) return false;
        for (BienLai bl : danhSachBienLai) {
            if (bl.getKhachHang().getMaSoCongTo().equalsIgnoreCase(maSoCongTo.trim())) {
                if (tenMoi != null && !tenMoi.trim().isEmpty()) {
                    bl.getKhachHang().setHoTenChuHo(tenMoi.trim());
                }
                if (soNhaMoi != null && !soNhaMoi.trim().isEmpty()) {
                    bl.getKhachHang().setSoNha(soNhaMoi.trim());
                }
                return true;
            }
        }
        return false;
    }

    public boolean xoaBienLai(String maSoCongTo) {
        if (maSoCongTo == null || maSoCongTo.trim().isEmpty()) return false;
        return danhSachBienLai.removeIf(bl -> bl.getKhachHang().getMaSoCongTo().equalsIgnoreCase(maSoCongTo.trim()));
    }

    public void hienThiDanhSach() {
        if (danhSachBienLai.isEmpty()) {
            System.out.println("Hệ thống hiện chưa có thông tin biên lai nào.");
            return;
        }
        System.out.println("----- DANH SÁCH BIÊN LAI THU TIỀN ĐIỆN (" + danhSachBienLai.size() + ") -----");
        for (int i = 0; i < danhSachBienLai.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachBienLai.get(i));
        }
    }

    public List<BienLai> getDanhSachBienLai() {
        return danhSachBienLai;
    }
}
