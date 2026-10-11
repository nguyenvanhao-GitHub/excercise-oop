package b12;

public class PhuongTien {
    private String id;
    private String hangSanXuat;
    private int namSanXuat;
    private double giaBan;
    private String mauXe;

    public PhuongTien() {
    }

    public PhuongTien(String id, String hangSanXuat, int namSanXuat, double giaBan, String mauXe) {
        this.id = id;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.giaBan = giaBan;
        this.mauXe = mauXe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getMauXe() {
        return mauXe;
    }

    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Hãng: " + hangSanXuat +
                ", Năm SX: " + namSanXuat +
                ", Giá bán: " + String.format("%,.0f", giaBan) + " VNĐ" +
                ", Màu: " + mauXe;
    }
}
