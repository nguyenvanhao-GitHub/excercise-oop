package oop_officer_management;

public class CongNhan extends CanBo {
    private int bac; // Báº­c tá»« 1 Ä‘áº¿n 10

    public CongNhan() {
    }

    public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi, int bac) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    @Override
    public String toString() {
        return "CÃ´ng NhÃ¢n [" + super.toString() + ", Báº­c: " + bac + "/10]";
    }
}
