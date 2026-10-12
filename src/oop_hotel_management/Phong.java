package oop_hotel_management;

public class Phong {
    protected String loaiPhong;
    protected double giaPhong;

    public Phong() {
    }

    public Phong(String loaiPhong, double giaPhong) {
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public double getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(double giaPhong) {
        this.giaPhong = giaPhong;
    }

    @Override
    public String toString() {
        return "Loại phòng: " + loaiPhong + ", Giá: " + giaPhong + "$/ngày";
    }
}
