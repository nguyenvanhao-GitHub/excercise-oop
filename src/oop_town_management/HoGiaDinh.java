package oop_town_management;

import java.util.ArrayList;
import java.util.List;

public class HoGiaDinh {
    private int soThanhVien;
    private String soNha;
    private List<Nguoi> thanhVien;

    public HoGiaDinh() {
        this.thanhVien = new ArrayList<>();
    }

    public HoGiaDinh(int soThanhVien, String soNha, List<Nguoi> thanhVien) {
        this.soThanhVien = soThanhVien;
        this.soNha = soNha;
        this.thanhVien = thanhVien != null ? thanhVien : new ArrayList<>();
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public List<Nguoi> getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(List<Nguoi> thanhVien) {
        this.thanhVien = thanhVien;
        this.soThanhVien = thanhVien != null ? thanhVien.size() : 0;
    }

    public void themThanhVien(Nguoi nguoi) {
        if (nguoi != null) {
            this.thanhVien.add(nguoi);
            this.soThanhVien = this.thanhVien.size();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Số nhà: ").append(soNha)
          .append(" | Số thành viên: ").append(soThanhVien).append("\n");
        for (int i = 0; i < thanhVien.size(); i++) {
            sb.append("   - Thành viên ").append(i + 1).append(": ").append(thanhVien.get(i)).append("\n");
        }
        return sb.toString();
    }
}
