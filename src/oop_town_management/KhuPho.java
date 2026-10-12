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
            System.out.println("Khu phố hiện chưa có thông tin hộ gia đình nào.");
            return;
        }
        System.out.println("==================================================");
        System.out.println("     DANH SÁCH CÁC HỘ GIA ĐÌNH TRONG KHU PHỐ      ");
        System.out.println("==================================================");
        for (int i = 0; i < danhSachHoGiaDinh.size(); i++) {
            System.out.println("[HỘ DÂN " + (i + 1) + "]");
            System.out.print(danhSachHoGiaDinh.get(i));
        }
    }

    public List<HoGiaDinh> getDanhSachHoGiaDinh() {
        return danhSachHoGiaDinh;
    }
}
