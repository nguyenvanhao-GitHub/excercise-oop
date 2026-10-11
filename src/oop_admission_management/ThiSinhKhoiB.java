package oop_admission_management;

public class ThiSinhKhoiB extends ThiSinh {
    public static final String MON_THI = "ToÃ¡n, HoÃ¡, Sinh";

    public ThiSinhKhoiB() {
    }

    public ThiSinhKhoiB(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public String toString() {
        return "ThÃ­ sinh Khá»‘i B [" + super.toString() + ", MÃ´n thi: " + MON_THI + "]";
    }
}
