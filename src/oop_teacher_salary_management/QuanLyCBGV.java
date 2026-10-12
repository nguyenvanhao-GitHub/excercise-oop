package oop_teacher_salary_management;

import java.util.ArrayList;
import java.util.List;

public class QuanLyCBGV {
    private final List<CBGV> danhSachCBGV;

    public QuanLyCBGV() {
        this.danhSachCBGV = new ArrayList<>();
    }

    public boolean themCBGV(CBGV cbgv) {
        if (cbgv == null) return false;
        boolean tonTai = danhSachCBGV.stream()
                .anyMatch(gv -> gv.getMaSoGV().equalsIgnoreCase(cbgv.getMaSoGV()));
        if (tonTai) {
            return false;
        }
        danhSachCBGV.add(cbgv);
        return true;
    }

    public boolean xoaCBGV(String maSoGV) {
        if (maSoGV == null || maSoGV.trim().isEmpty()) return false;
        return danhSachCBGV.removeIf(gv -> gv.getMaSoGV().equalsIgnoreCase(maSoGV.trim()));
    }

    public void hienThiDanhSach() {
        if (danhSachCBGV.isEmpty()) {
            System.out.println("Khoa CNTT hiện chưa có hồ sơ cán bộ giáo viên nào.");
            return;
        }
        System.out.println("----- DANH SÁCH CÁN BỘ GIÁO VIÊN VÀ LƯƠNG (" + danhSachCBGV.size() + ") -----");
        for (int i = 0; i < danhSachCBGV.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachCBGV.get(i));
        }
    }

    public List<CBGV> getDanhSachCBGV() {
        return danhSachCBGV;
    }
}
