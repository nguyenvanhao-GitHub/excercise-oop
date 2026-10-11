package b8;

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
            System.out.println("Thư viện hiện chưa có phiếu mượn sách nào.");
            return;
        }
        System.out.println("----- DANH SÁCH THẺ MƯỢN SÁCH (" + danhSachTheMuon.size() + ") -----");
        for (int i = 0; i < danhSachTheMuon.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachTheMuon.get(i));
        }
    }

    public List<TheMuon> getDanhSachTheMuon() {
        return danhSachTheMuon;
    }
}
