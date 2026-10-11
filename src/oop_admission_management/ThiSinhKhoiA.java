package oop_admission_management;

public class ThiSinhKhoiA extends ThiSinh {
    public static final String MON_THI = "ToÃ¡n, LÃ½, HoÃ¡";

    public ThiSinhKhoiA() {
    }

    public ThiSinhKhoiA(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public String toString() {
        return "ThÃ­ sinh Khá»‘i A [" + super.toString() + ", MÃ´n thi: " + MON_THI + "]";
    }
}
