package oop_officer_management;

public class NhanVien extends CanBo {
    private String congViec;

    public NhanVien() {
    }

    public NhanVien(String hoTen, int tuoi, String gioiTinh, String diaChi, String congViec) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    @Override
    public String toString() {
        return "NhÃ¢n ViÃªn Phá»¥c Vá»¥ [" + super.toString() + ", CÃ´ng viá»‡c: " + congViec + "]";
    }
}
