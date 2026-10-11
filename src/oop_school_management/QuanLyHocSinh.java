package oop_school_management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyHocSinh {
    private final List<HocSinh> danhSachHocSinh;

    public QuanLyHocSinh() {
        this.danhSachHocSinh = new ArrayList<>();
    }

    public void themHocSinh(HocSinh hocSinh) {
        if (hocSinh != null) {
            danhSachHocSinh.add(hocSinh);
        }
    }

    public void hienThiDanhSach() {
        if (danhSachHocSinh.isEmpty()) {
            System.out.println("Danh sÃ¡ch há»c sinh hiá»‡n Ä‘ang trá»‘ng.");
            return;
        }
        System.out.println("----- Táº¤T Cáº¢ Há»ŒC SINH (" + danhSachHocSinh.size() + ") -----");
        for (int i = 0; i < danhSachHocSinh.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachHocSinh.get(i));
        }
    }

    public List<HocSinh> timHocSinh20Tuoi() {
        return danhSachHocSinh.stream()
                .filter(hs -> hs.getTuoi() == 20)
                .collect(Collectors.toList());
    }

    public long demHocSinh23TuoiQueDN() {
        return danhSachHocSinh.stream()
                .filter(hs -> hs.getTuoi() == 23 && (
                        hs.getQueQuan().equalsIgnoreCase("DN") ||
                        hs.getQueQuan().equalsIgnoreCase("ÄÃ  Náºµng") ||
                        hs.getQueQuan().equalsIgnoreCase("Da Nang")
                ))
                .count();
    }

    public List<HocSinh> getDanhSachHocSinh() {
        return danhSachHocSinh;
    }
}
