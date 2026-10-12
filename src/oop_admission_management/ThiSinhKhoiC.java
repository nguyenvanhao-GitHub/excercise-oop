package oop_admission_management;

public class ThiSinhKhoiC extends ThiSinh {
    public static final String MON_THI = "Văn, Sử, Địa";

    public ThiSinhKhoiC() {
    }

    public ThiSinhKhoiC(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public String toString() {
        return "Thí sinh Khối C [" + super.toString() + ", Môn thi: " + MON_THI + "]";
    }
}
