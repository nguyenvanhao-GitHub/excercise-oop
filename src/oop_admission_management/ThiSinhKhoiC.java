package oop_admission_management;

public class ThiSinhKhoiC extends ThiSinh {
    public static final String MON_THI = "VÄƒn, Sá»­, Äá»‹a";

    public ThiSinhKhoiC() {
    }

    public ThiSinhKhoiC(String soBaoDanh, String hoTen, String diaChi, int mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public String toString() {
        return "ThÃ­ sinh Khá»‘i C [" + super.toString() + ", MÃ´n thi: " + MON_THI + "]";
    }
}
