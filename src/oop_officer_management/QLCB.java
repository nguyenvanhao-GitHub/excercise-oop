package oop_officer_management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QLCB {
    private final List<CanBo> danhSachCanBo;

    public QLCB() {
        this.danhSachCanBo = new ArrayList<>();
    }

    public void themCanBo(CanBo canBo) {
        if (canBo != null) {
            this.danhSachCanBo.add(canBo);
        }
    }

    public List<CanBo> timKiemTheoHoTen(String hoTen) {
        if (hoTen == null || hoTen.trim().isEmpty()) {
            return new ArrayList<>();
        }
        String keyword = hoTen.trim().toLowerCase();
        return this.danhSachCanBo.stream()
                .filter(cb -> cb.getHoTen().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    public void hienThiDanhSach() {
        if (this.danhSachCanBo.isEmpty()) {
            System.out.println("Danh sách cán bộ hiện đang trống.");
            return;
        }
        System.out.println("----- DANH SÁCH CÁN BỘ (" + danhSachCanBo.size() + ") -----");
        for (int i = 0; i < this.danhSachCanBo.size(); i++) {
            System.out.println((i + 1) + ". " + this.danhSachCanBo.get(i));
        }
    }

    public List<CanBo> getDanhSachCanBo() {
        return danhSachCanBo;
    }
}
