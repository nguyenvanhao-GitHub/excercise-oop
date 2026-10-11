package oop_electricity_bill_management;

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

    // Tiá»n Ä‘iá»‡n = (chá»‰ sá»‘ má»›i - chá»‰ sá»‘ cÅ©) * 5
    public double tinhTienDien() {
        if (chiSoMoi < chiSoCu) return 0;
        return (chiSoMoi - chiSoCu) * 5;
    }

    @Override
    public String toString() {
        return "BiÃªn lai [" + khachHang +
                ", Chá»‰ sá»‘ cÅ©: " + chiSoCu +
                ", Chá»‰ sá»‘ má»›i: " + chiSoMoi +
                ", Äiá»‡n tiÃªu thá»¥: " + (chiSoMoi - chiSoCu) + " kWh" +
                ", Sá»‘ tiá»n pháº£i tráº£: " + String.format("%,.2f", tinhTienDien()) + " VNÄ]";
    }
}
