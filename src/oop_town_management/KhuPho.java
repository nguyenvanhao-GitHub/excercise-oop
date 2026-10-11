package oop_town_management;

import java.util.ArrayList;
import java.util.List;

public class KhuPho {
    private final List<HoGiaDinh> danhSachHoGiaDinh;

    public KhuPho() {
        this.danhSachHoGiaDinh = new ArrayList<>();
    }

    public void themHoGiaDinh(HoGiaDinh hoGiaDinh) {
        if (hoGiaDinh != null) {
            danhSachHoGiaDinh.add(hoGiaDinh);
        }
    }

    public void hienThiThongTin() {
        if (danhSachHoGiaDinh.isEmpty()) {
            System.out.println("Khu phá»‘ hiá»‡n chÆ°a cÃ³ thÃ´ng tin há»™ gia Ä‘Ã¬nh nÃ o.");
            return;
        }
        System.out.println("==================================================");
        System.out.println("     DANH SÃCH CÃC Há»˜ GIA ÄÃŒNH TRONG KHU PHá»      ");
        System.out.println("==================================================");
        for (int i = 0; i < danhSachHoGiaDinh.size(); i++) {
            System.out.println("[Há»˜ DÃ‚N " + (i + 1) + "]");
            System.out.print(danhSachHoGiaDinh.get(i));
        }
    }

    public List<HoGiaDinh> getDanhSachHoGiaDinh() {
        return danhSachHoGiaDinh;
    }
}
