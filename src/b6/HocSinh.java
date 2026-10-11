package b6;

public class HocSinh {
    private String hoTen;
    private int tuoi;
    private String queQuan;
    private String lop;

    public HocSinh() {
    }

    public HocSinh(String hoTen, int tuoi, String queQuan, String lop) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.lop = lop;
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

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "Học sinh [Họ tên: " + hoTen +
                ", Tuổi: " + tuoi +
                ", Quê quán: " + queQuan +
                ", Lớp: " + lop + "]";
    }
}
