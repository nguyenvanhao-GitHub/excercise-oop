package oop_document_management;

public class Sach extends TaiLieu {
    private String tenTacGia;
    private int soTrang;

    public Sach() {
    }

    public Sach(String maTaiLieu, String tenNXB, int soBanPhatHanh, String tenTacGia, int soTrang) {
        super(maTaiLieu, tenNXB, soBanPhatHanh);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    @Override
    public String toString() {
        return "SÃ¡ch [" + super.toString() +
                ", TÃ¡c giáº£: " + tenTacGia +
                ", Sá»‘ trang: " + soTrang + "]";
    }
}
