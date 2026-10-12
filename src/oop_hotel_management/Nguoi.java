package oop_hotel_management;

public class Nguoi {
    private String hoTen;
    private int tuoi;
    private String soCMND;

    public Nguoi() {
    }

    public Nguoi(String hoTen, int tuoi, String soCMND) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.soCMND = soCMND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    @Override
    public String toString() {
        return "CMND: " + soCMND + ", Họ tên: " + hoTen + ", Tuổi: " + tuoi;
    }
}
