package oop_electricity_bill_management;

public class KhachHang {
    private String hoTenChuHo;
    private String soNha;
    private String maSoCongTo; // Duy nhất

    public KhachHang() {
    }

    public KhachHang(String hoTenChuHo, String soNha, String maSoCongTo) {
        this.hoTenChuHo = hoTenChuHo;
        this.soNha = soNha;
        this.maSoCongTo = maSoCongTo;
    }

    public String getHoTenChuHo() {
        return hoTenChuHo;
    }

    public void setHoTenChuHo(String hoTenChuHo) {
        this.hoTenChuHo = hoTenChuHo;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getMaSoCongTo() {
        return maSoCongTo;
    }

    public void setMaSoCongTo(String maSoCongTo) {
        this.maSoCongTo = maSoCongTo;
    }

    @Override
    public String toString() {
        return "Mã công tơ: " + maSoCongTo +
                ", Chủ hộ: " + hoTenChuHo +
                ", Số nhà: " + soNha;
    }
}
