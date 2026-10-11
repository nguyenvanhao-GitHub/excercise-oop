package oop_library_borrow_management;

import java.util.ArrayList;
import java.util.List;

public class QuanLyTheMuon {
    private final List<TheMuon> danhSachTheMuon;

    public QuanLyTheMuon() {
        this.danhSachTheMuon = new ArrayList<>();
    }

    public boolean themTheMuon(TheMuon theMuon) {
        if (theMuon == null) return false;
        boolean tonTai = danhSachTheMuon.stream()
                .anyMatch(tm -> tm.getMaPhieuMuon().equalsIgnoreCase(theMuon.getMaPhieuMuon()));
        if (tonTai) {
            return false;
        }
        danhSachTheMuon.add(theMuon);
        return true;
    }

    public boolean xoaTheMuon(String maPhieuMuon) {
        if (maPhieuMuon == null || maPhieuMuon.trim().isEmpty()) return false;
        return danhSachTheMuon.removeIf(tm -> tm.getMaPhieuMuon().equalsIgnoreCase(maPhieuMuon.trim()));
    }

    public void hienThiDanhSach() {
        if (danhSachTheMuon.isEmpty()) {
            System.out.println("ThÆ° viá»‡n hiá»‡n chÆ°a cÃ³ phiáº¿u mÆ°á»£n sÃ¡ch nÃ o.");
            return;
        }
        System.out.println("----- DANH SÃCH THáºº MÆ¯á»¢N SÃCH (" + danhSachTheMuon.size() + ") -----");
        for (int i = 0; i < danhSachTheMuon.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachTheMuon.get(i));
        }
    }

    public List<TheMuon> getDanhSachTheMuon() {
        return danhSachTheMuon;
    }
}
