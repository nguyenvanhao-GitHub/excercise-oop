package oop_hotel_management;

public class KhachThue {
    private Nguoi nguoi;
    private Phong phong;
    private int soNgayThue;

    public KhachThue() {
    }

    public KhachThue(Nguoi nguoi, Phong phong, int soNgayThue) {
        this.nguoi = nguoi;
        this.phong = phong;
        this.soNgayThue = soNgayThue;
    }

    public Nguoi getNguoi() {
        return nguoi;
    }

    public void setNguoi(Nguoi nguoi) {
        this.nguoi = nguoi;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public int getSoNgayThue() {
        return soNgayThue;
    }

    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }

    public double tinhTien() {
        if (phong == null) return 0.0;
        return soNgayThue * phong.getGiaPhong();
    }

    @Override
    public String toString() {
        return "KhÃ¡ch hÃ ng [" + nguoi + "] | " + phong + " | Sá»‘ ngÃ y thuÃª: " + soNgayThue + " | Tiá»n dá»± kiáº¿n: " + tinhTien() + "$";
    }
}
