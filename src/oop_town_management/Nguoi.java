package oop_town_management;

public class Nguoi {
    private String hoTen;
    private int tuoi;
    private String ngheNghiep;
    private String soCMND; // Duy nháº¥t cho má»—i ngÆ°á»i

    public Nguoi() {
    }

    public Nguoi(String hoTen, int tuoi, String ngheNghiep, String soCMND) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.ngheNghiep = ngheNghiep;
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

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    @Override
    public String toString() {
        return "CMND: " + soCMND +
                ", Há» tÃªn: " + hoTen +
                ", Tuá»•i: " + tuoi +
                ", Nghá» nghiá»‡p: " + ngheNghiep;
    }
}
