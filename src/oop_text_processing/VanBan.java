package oop_text_processing;

public class VanBan {
    private String noiDung;

    // YÃªu cáº§u 1: HÃ m khá»Ÿi táº¡o khÃ´ng tham sá»‘ vÃ  cÃ³ tham sá»‘
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

    // YÃªu cáº§u 2: PhÆ°Æ¡ng thá»©c Ä‘áº¿m sá»‘ tá»« cá»§a vÄƒn báº£n
    public int demSoTu() {
        if (noiDung == null || noiDung.trim().isEmpty()) {
            return 0;
        }
        String[] tu = noiDung.trim().split("\\s+");
        return tu.length;
    }

    // YÃªu cáº§u 3: PhÆ°Æ¡ng thá»©c Ä‘áº¿m sá»‘ lÆ°á»£ng kÃ½ tá»± A (khÃ´ng phÃ¢n biá»‡t hoa thÆ°á»ng)
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

    // YÃªu cáº§u 4: Chuáº©n hoÃ¡ vÄƒn báº£n (Ä‘áº§u/cuá»‘i khÃ´ng cÃ³ khoáº£ng tráº¯ng, giá»¯a khÃ´ng cÃ³ 2 khoáº£ng tráº¯ng liá»n ká»)
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
