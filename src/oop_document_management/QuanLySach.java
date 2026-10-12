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
        // Kiểm tra mã tài liệu đã tồn tại chưa (mã tài liệu là duy nhất)
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
            System.out.println("Thư viện hiện chưa có tài liệu nào.");
            return;
        }
        System.out.println("----- DANH SÁCH TÀI LIỆU (" + danhSachTaiLieu.size() + ") -----");
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
