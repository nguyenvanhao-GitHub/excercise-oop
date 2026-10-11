package b10;

public class VanBan {
    private String noiDung;

    // Yêu cầu 1: Hàm khởi tạo không tham số và có tham số
    public VanBan() {
        this.noiDung = "";
    }

    public VanBan(String st) {
        this.noiDung = st != null ? st : "";
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung != null ? noiDung : "";
    }

    // Yêu cầu 2: Phương thức đếm số từ của văn bản
    public int demSoTu() {
        if (noiDung == null || noiDung.trim().isEmpty()) {
            return 0;
        }
        String[] tu = noiDung.trim().split("\\s+");
        return tu.length;
    }

    // Yêu cầu 3: Phương thức đếm số lượng ký tự A (không phân biệt hoa thường)
    public int demKyTuA() {
        if (noiDung == null || noiDung.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < noiDung.length(); i++) {
            char c = Character.toLowerCase(noiDung.charAt(i));
            if (c == 'a') {
                count++;
            }
        }
        return count;
    }

    // Yêu cầu 4: Chuẩn hoá văn bản (đầu/cuối không có khoảng trắng, giữa không có 2 khoảng trắng liền kề)
    public String chuanHoa() {
        if (noiDung == null) {
            return "";
        }
        this.noiDung = noiDung.trim().replaceAll("\\s+", " ");
        return this.noiDung;
    }

    @Override
    public String toString() {
        return noiDung;
    }
}
