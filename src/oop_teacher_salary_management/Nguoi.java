package oop_teacher_salary_management;

public class Nguoi {
    private String hoTen;
    private int tuoi;
    private String queQuan;
    private String maSoGV;

    public Nguoi() {
    }

    public Nguoi(String hoTen, int tuoi, String queQuan, String maSoGV) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.maSoGV = maSoGV;
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

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getMaSoGV() {
        return maSoGV;
    }

    public void setMaSoGV(String maSoGV) {
        this.maSoGV = maSoGV;
    }

    @Override
    public String toString() {
        return "Mã GV: " + maSoGV +
                ", Họ tên: " + hoTen +
                ", Tuổi: " + tuoi +
                ", Quê quán: " + queQuan;
    }
}
