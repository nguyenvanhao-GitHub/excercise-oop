package oop_officer_management;

public class CongNhan extends CanBo {
    private int bac; // Bậc từ 1 đến 10

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
        return "Công Nhân [" + super.toString() + ", Bậc: " + bac + "/10]";
    }
}
