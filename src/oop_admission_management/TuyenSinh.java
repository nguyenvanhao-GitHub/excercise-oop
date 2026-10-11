package oop_admission_management;

import java.util.ArrayList;
import java.util.List;

public class TuyenSinh {
    private final List<ThiSinh> danhSachThiSinh;

    public TuyenSinh() {
        this.danhSachThiSinh = new ArrayList<>();
    }

    public boolean themThiSinh(ThiSinh thiSinh) {
        if (thiSinh == null) return false;
        // Kiá»ƒm tra sá»‘ bÃ¡o danh duy nháº¥t
        boolean tonTai = danhSachThiSinh.stream()
                .anyMatch(ts -> ts.getSoBaoDanh().equalsIgnoreCase(thiSinh.getSoBaoDanh()));
        if (tonTai) {
            return false;
        }
        danhSachThiSinh.add(thiSinh);
        return true;
    }

    public void hienThiThongTin() {
        if (danhSachThiSinh.isEmpty()) {
            System.out.println("Danh sÃ¡ch thÃ­ sinh dá»± thi hiá»‡n Ä‘ang trá»‘ng.");
            return;
        }
        System.out.println("----- DANH SÃCH THÃ SINH Dá»° THI Äáº I Há»ŒC (" + danhSachThiSinh.size() + ") -----");
        for (int i = 0; i < danhSachThiSinh.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachThiSinh.get(i));
        }
    }

    public ThiSinh timKiemTheoSoBaoDanh(String soBaoDanh) {
        if (soBaoDanh == null || soBaoDanh.trim().isEmpty()) return null;
        return danhSachThiSinh.stream()
                .filter(ts -> ts.getSoBaoDanh().equalsIgnoreCase(soBaoDanh.trim()))
                .findFirst()
                .orElse(null);
    }

    public List<ThiSinh> getDanhSachThiSinh() {
        return danhSachThiSinh;
    }
}
