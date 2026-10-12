package oop_vehicle_management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QLPTGT {
    private final List<PhuongTien> danhSachPhuongTien;

    public QLPTGT() {
        this.danhSachPhuongTien = new ArrayList<>();
    }

    public boolean themPhuongTien(PhuongTien pt) {
        if (pt == null) return false;
        boolean tonTai = danhSachPhuongTien.stream()
                .anyMatch(p -> p.getId().equalsIgnoreCase(pt.getId()));
        if (tonTai) {
            return false;
        }
        danhSachPhuongTien.add(pt);
        return true;
    }

    public boolean xoaPhuongTien(String id) {
        if (id == null || id.trim().isEmpty()) return false;
        return danhSachPhuongTien.removeIf(p -> p.getId().equalsIgnoreCase(id.trim()));
    }

    public List<PhuongTien> timKiemTheoHangSanXuat(String hangSX) {
        if (hangSX == null || hangSX.trim().isEmpty()) return new ArrayList<>();
        String keyword = hangSX.trim().toLowerCase();
        return danhSachPhuongTien.stream()
                .filter(p -> p.getHangSanXuat().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    public List<PhuongTien> timKiemTheoMau(String mauXe) {
        if (mauXe == null || mauXe.trim().isEmpty()) return new ArrayList<>();
        String keyword = mauXe.trim().toLowerCase();
        return danhSachPhuongTien.stream()
                .filter(p -> p.getMauXe().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    public void hienThiDanhSach() {
        if (danhSachPhuongTien.isEmpty()) {
            System.out.println("Hệ thống hiện chưa có phương tiện nào.");
            return;
        }
        System.out.println("----- DANH SÁCH PHƯƠNG TIỆN GIAO THÔNG (" + danhSachPhuongTien.size() + ") -----");
        for (int i = 0; i < danhSachPhuongTien.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachPhuongTien.get(i));
        }
    }

    public List<PhuongTien> getDanhSachPhuongTien() {
        return danhSachPhuongTien;
    }
}
