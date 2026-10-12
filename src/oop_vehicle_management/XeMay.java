package oop_vehicle_management;

public class XeMay extends PhuongTien {
    private double congXuat;

    public XeMay() {
    }

    public XeMay(String id, String hangSanXuat, int namSanXuat, double giaBan, String mauXe, double congXuat) {
        super(id, hangSanXuat, namSanXuat, giaBan, mauXe);
        this.congXuat = congXuat;
    }

    public double getCongXuat() {
        return congXuat;
    }

    public void setCongXuat(double congXuat) {
        this.congXuat = congXuat;
    }

    @Override
    public String toString() {
        return "Xe máy [" + super.toString() +
                ", Công suất: " + congXuat + " HP]";
    }
}
