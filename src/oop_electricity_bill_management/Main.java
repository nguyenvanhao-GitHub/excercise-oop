package oop_electricity_bill_management;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuanLyBienLai qlbl = new QuanLyBienLai();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUáº¢N LÃ BIÃŠN LAI THU TIá»€N ÄIá»†N (BÃ€I 9) ==========");
            System.out.println("1. ThÃªm má»›i há»™ sá»­ dá»¥ng Ä‘iá»‡n & biÃªn lai");
            System.out.println("2. Sá»­a thÃ´ng tin há»™ sá»­ dá»¥ng Ä‘iá»‡n theo mÃ£ cÃ´ng tÆ¡");
            System.out.println("3. XÃ³a há»™ sá»­ dá»¥ng Ä‘iá»‡n theo mÃ£ cÃ´ng tÆ¡");
            System.out.println("4. Hiá»ƒn thá»‹ danh sÃ¡ch biÃªn lai vÃ  sá»‘ tiá»n Ä‘iá»‡n pháº£i tráº£");
            System.out.println("0. ThoÃ¡t khá»i chÆ°Æ¡ng trÃ¬nh");
            System.out.print(">> Nháº­p lá»±a chá»n cá»§a báº¡n: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiBienLai();
                    break;
                case 2:
                    suaThongTin();
                    break;
                case 3:
                    xoaBienLai();
                    break;
                case 4:
                    qlbl.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("ÄÃ£ thoÃ¡t chÆ°Æ¡ng trÃ¬nh Quáº£n lÃ½ biÃªn lai Ä‘iá»‡n.");
                    break;
                default:
                    System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡, vui lÃ²ng chá»n láº¡i!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiBienLai() {
        System.out.print("Nháº­p mÃ£ sá»‘ cÃ´ng tÆ¡ Ä‘iá»‡n: ");
        String maCongTo = scanner.nextLine().trim();

        System.out.print("Nháº­p há» tÃªn chá»§ há»™: ");
        String chuHo = scanner.nextLine().trim();

        System.out.print("Nháº­p sá»‘ nhÃ : ");
        String soNha = scanner.nextLine().trim();

        System.out.print("Nháº­p chá»‰ sá»‘ Ä‘iá»‡n cÅ©: ");
        double chiSoCu;
        try {
            chiSoCu = Double.parseDouble(scanner.nextLine().trim());
            if (chiSoCu < 0) {
                System.out.println("Chá»‰ sá»‘ Ä‘iá»‡n khÃ´ng Ä‘Æ°á»£c Ã¢m!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Chá»‰ sá»‘ Ä‘iá»‡n cÅ© pháº£i lÃ  sá»‘!");
            return;
        }

        System.out.print("Nháº­p chá»‰ sá»‘ Ä‘iá»‡n má»›i: ");
        double chiSoMoi;
        try {
            chiSoMoi = Double.parseDouble(scanner.nextLine().trim());
            if (chiSoMoi < chiSoCu) {
                System.out.println("Chá»‰ sá»‘ Ä‘iá»‡n má»›i pháº£i lá»›n hÆ¡n hoáº·c báº±ng chá»‰ sá»‘ cÅ©!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Chá»‰ sá»‘ Ä‘iá»‡n má»›i pháº£i lÃ  sá»‘!");
            return;
        }

        KhachHang kh = new KhachHang(chuHo, soNha, maCongTo);
        BienLai bl = new BienLai(kh, chiSoCu, chiSoMoi);

        boolean thanhCong = qlbl.themBienLai(bl);
        if (thanhCong) {
            System.out.println(">> ThÃªm biÃªn lai thÃ nh cÃ´ng! Tiá»n Ä‘iá»‡n pháº£i tráº£: " +
                    String.format("%,.2f", bl.tinhTienDien()) + " VNÄ");
        } else {
            System.out.println(">> Tháº¥t báº¡i: MÃ£ cÃ´ng tÆ¡ '" + maCongTo + "' Ä‘Ã£ tá»“n táº¡i!");
        }
    }

    private static void suaThongTin() {
        System.out.print("Nháº­p mÃ£ cÃ´ng tÆ¡ cáº§n sá»­a thÃ´ng tin: ");
        String ma = scanner.nextLine().trim();

        System.out.print("Nháº­p há» tÃªn chá»§ há»™ má»›i (bá» trá»‘ng náº¿u khÃ´ng Ä‘á»•i): ");
        String tenMoi = scanner.nextLine().trim();

        System.out.print("Nháº­p sá»‘ nhÃ  má»›i (bá» trá»‘ng náº¿u khÃ´ng Ä‘á»•i): ");
        String soNhaMoi = scanner.nextLine().trim();

        boolean daSua = qlbl.suaThongTinKhachHang(ma, tenMoi, soNhaMoi);
        if (daSua) {
            System.out.println(">> Sá»­a thÃ´ng tin thÃ nh cÃ´ng cho mÃ£ cÃ´ng tÆ¡: " + ma);
        } else {
            System.out.println(">> KhÃ´ng tÃ¬m tháº¥y há»™ cÃ³ mÃ£ cÃ´ng tÆ¡: " + ma);
        }
    }

    private static void xoaBienLai() {
        System.out.print("Nháº­p mÃ£ cÃ´ng tÆ¡ cáº§n xÃ³a: ");
        String ma = scanner.nextLine().trim();
        boolean daXoa = qlbl.xoaBienLai(ma);
        if (daXoa) {
            System.out.println(">> ÄÃ£ xÃ³a biÃªn lai cÃ³ mÃ£ cÃ´ng tÆ¡: " + ma);
        } else {
            System.out.println(">> KhÃ´ng tÃ¬m tháº¥y há»™ cÃ³ mÃ£ cÃ´ng tÆ¡: " + ma);
        }
    }
}
