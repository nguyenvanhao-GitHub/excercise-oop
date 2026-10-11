package oop_document_management;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLySach {
    private final List<TaiLieu> danhSachTaiLieu;

    public QuanLySach() {
        this.danhSachTaiLieu = new ArrayList<>();
    }

    public boolean themTaiLieu(TaiLieu taiLieu) {
        if (taiLieu == null) return false;
        // Kiá»ƒm tra mÃ£ tÃ i liá»‡u Ä‘Ã£ tá»“n táº¡i chÆ°a (mÃ£ tÃ i liá»‡u lÃ  duy nháº¥t)
        boolean daTonTai = danhSachTaiLieu.stream()
                .anyMatch(tl -> tl.getMaTaiLieu().equalsIgnoreCase(taiLieu.getMaTaiLieu()));
        if (daTonTai) {
            return false;
        }
        danhSachTaiLieu.add(taiLieu);
        return true;
    }

    public boolean xoaTaiLieu(String maTaiLieu) {
        if (maTaiLieu == null || maTaiLieu.trim().isEmpty()) return false;
        return danhSachTaiLieu.removeIf(tl -> tl.getMaTaiLieu().equalsIgnoreCase(maTaiLieu.trim()));
    }

    public void hienThiThongTin() {
        if (danhSachTaiLieu.isEmpty()) {
            System.out.println("ThÆ° viá»‡n hiá»‡n chÆ°a cÃ³ tÃ i liá»‡u nÃ o.");
            return;
        }
        System.out.println("----- DANH SÃCH TÃ€I LIá»†U (" + danhSachTaiLieu.size() + ") -----");
        for (int i = 0; i < danhSachTaiLieu.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachTaiLieu.get(i));
        }
    }

    public List<TaiLieu> timKiemTheoLoai(String loai) {
        if (loai == null) return new ArrayList<>();
        String normalized = loai.trim().toLowerCase();
        return danhSachTaiLieu.stream().filter(tl -> {
            if (normalized.contains("sach") || normalized.equals("1")) {
                return tl instanceof Sach;
            } else if (normalized.contains("tap chi") || normalized.contains("tapchi") || normalized.equals("2")) {
                return tl instanceof TapChi;
            } else if (normalized.contains("bao") || normalized.equals("3")) {
                return tl instanceof Bao;
            }
            return false;
        }).collect(Collectors.toList());
    }

    public List<TaiLieu> getDanhSachTaiLieu() {
        return danhSachTaiLieu;
    }
}
