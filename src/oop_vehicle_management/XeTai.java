package oop_vehicle_management;

public class XeTai extends PhuongTien {
    private double trongTai;

    public XeTai() {
    }

    public XeTai(String id, String hangSanXuat, int namSanXuat, double giaBan, String mauXe, double trongTai) {
        super(id, hangSanXuat, namSanXuat, giaBan, mauXe);
        this.trongTai = trongTai;
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "Xe táº£i [" + super.toString() +
                ", Trá»ng táº£i: " + trongTai + " táº¥n]";
    }
}
