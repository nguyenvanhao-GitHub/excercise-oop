package oop_admission_management;

public class ThiSinhKhoiA extends ThiSinh {
    public static final String MON_THI = "Toán, Lý, Hoá";

    public ThiSinhKhoiA() {
    }

    public ThiSinhKhoiA(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public String toString() {
        return "Thí sinh Khối A [" + super.toString() + ", Môn thi: " + MON_THI + "]";
    }
}
