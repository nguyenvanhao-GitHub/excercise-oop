package oop_teacher_salary_management;

public class CBGV extends Nguoi {
    private double luongCung;
    private double luongThuong;
    private double tienPhat;

    public CBGV() {
    }

    public CBGV(String hoTen, int tuoi, String queQuan, String maSoGV, double luongCung, double luongThuong, double tienPhat) {
        super(hoTen, tuoi, queQuan, maSoGV);
        this.luongCung = luongCung;
        this.luongThuong = luongThuong;
        this.tienPhat = tienPhat;
    }

    public double getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(double luongCung) {
        this.luongCung = luongCung;
    }

    public double getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(double luongThuong) {
        this.luongThuong = luongThuong;
    }

    public double getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }

    public double getLuongThucLinh() {
        return luongCung + luongThuong - tienPhat;
    }

    @Override
    public String toString() {
        return "CBGV [" + super.toString() +
                ", Lương cứng: " + String.format("%,.0f", luongCung) + " VNĐ" +
                ", Thưởng: " + String.format("%,.0f", luongThuong) + " VNĐ" +
                ", Phạt: " + String.format("%,.0f", tienPhat) + " VNĐ" +
                ", LƯƠNG THỰC LĨNH: " + String.format("%,.0f", getLuongThucLinh()) + " VNĐ]";
    }
}
