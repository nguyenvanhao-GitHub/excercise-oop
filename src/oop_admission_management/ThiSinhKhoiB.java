package oop_admission_management;

public class ThiSinhKhoiB extends ThiSinh {
    public static final String MON_THI = "Toán, Hoá, Sinh";

    public ThiSinhKhoiB() {
    }

    public ThiSinhKhoiB(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public String toString() {
        return "Thí sinh Khối B [" + super.toString() + ", Môn thi: " + MON_THI + "]";
    }
}
