package b9;

public class BienLai {
    private KhachHang khachHang;
    private double chiSoCu;
    private double chiSoMoi;

    public BienLai() {
    }

    public BienLai(KhachHang khachHang, double chiSoCu, double chiSoMoi) {
        this.khachHang = khachHang;
        this.chiSoCu = chiSoCu;
        this.chiSoMoi = chiSoMoi;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public double getChiSoCu() {
        return chiSoCu;
    }

    public void setChiSoCu(double chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public double getChiSoMoi() {
        return chiSoMoi;
    }

    public void setChiSoMoi(double chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }

    // Tiền điện = (chỉ số mới - chỉ số cũ) * 5
    public double tinhTienDien() {
        if (chiSoMoi < chiSoCu) return 0;
        return (chiSoMoi - chiSoCu) * 5;
    }

    @Override
    public String toString() {
        return "Biên lai [" + khachHang +
                ", Chỉ số cũ: " + chiSoCu +
                ", Chỉ số mới: " + chiSoMoi +
                ", Điện tiêu thụ: " + (chiSoMoi - chiSoCu) + " kWh" +
                ", Số tiền phải trả: " + String.format("%,.2f", tinhTienDien()) + " VNĐ]";
    }
}
