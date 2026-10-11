package oop_document_management;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuanLySach qls = new QuanLySach();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUáº¢N LÃ TÃ€I LIá»†U THÆ¯ VIá»†N (BÃ€I 2) ==========");
            System.out.println("1. ThÃªm má»›i tÃ i liá»‡u (SÃ¡ch, Táº¡p chÃ­, BÃ¡o)");
            System.out.println("2. XÃ³a tÃ i liá»‡u theo mÃ£ tÃ i liá»‡u");
            System.out.println("3. Hiá»ƒn thá»‹ thÃ´ng tin toÃ n bá»™ tÃ i liá»‡u");
            System.out.println("4. TÃ¬m kiáº¿m tÃ i liá»‡u theo loáº¡i (SÃ¡ch, Táº¡p chÃ­, BÃ¡o)");
            System.out.println("0. ThoÃ¡t khá»i chÆ°Æ¡ng trÃ¬nh");
            System.out.print(">> Nháº­p lá»±a chá»n cá»§a báº¡n: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiTaiLieu();
                    break;
                case 2:
                    xoaTaiLieu();
                    break;
                case 3:
                    qls.hienThiThongTin();
                    break;
                case 4:
                    timKiemTaiLieuTheoLoai();
                    break;
                case 0:
                    System.out.println("ÄÃ£ thoÃ¡t chÆ°Æ¡ng trÃ¬nh Quáº£n lÃ½ tÃ i liá»‡u.");
                    break;
                default:
                    System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡, vui lÃ²ng chá»n láº¡i!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiTaiLieu() {
        System.out.println("\n--- Chá»n loáº¡i tÃ i liá»‡u cáº§n thÃªm ---");
        System.out.println("1. SÃ¡ch");
        System.out.println("2. Táº¡p chÃ­");
        System.out.println("3. BÃ¡o");
        System.out.print(">> Lá»±a chá»n: ");
        int loai;
        try {
            loai = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡!");
            return;
        }

        System.out.print("Nháº­p mÃ£ tÃ i liá»‡u: ");
        String maTL = scanner.nextLine().trim();

        System.out.print("Nháº­p tÃªn nhÃ  xuáº¥t báº£n: ");
        String nxb = scanner.nextLine().trim();

        System.out.print("Nháº­p sá»‘ báº£n phÃ¡t hÃ nh: ");
        int soBan;
        try {
            soBan = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Sá»‘ báº£n phÃ¡t hÃ nh pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        TaiLieu taiLieu;
        switch (loai) {
            case 1:
                System.out.print("Nháº­p tÃªn tÃ¡c giáº£: ");
                String tacGia = scanner.nextLine().trim();
                System.out.print("Nháº­p sá»‘ trang: ");
                int soTrang;
                try {
                    soTrang = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Sá»‘ trang pháº£i lÃ  sá»‘ nguyÃªn!");
                    return;
                }
                taiLieu = new Sach(maTL, nxb, soBan, tacGia, soTrang);
                break;
            case 2:
                System.out.print("Nháº­p sá»‘ phÃ¡t hÃ nh: ");
                int soPhatHanh;
                try {
                    soPhatHanh = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Sá»‘ phÃ¡t hÃ nh pháº£i lÃ  sá»‘ nguyÃªn!");
                    return;
                }
                System.out.print("Nháº­p thÃ¡ng phÃ¡t hÃ nh (1 - 12): ");
                int thangPhatHanh;
                try {
                    thangPhatHanh = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("ThÃ¡ng phÃ¡t hÃ nh pháº£i lÃ  sá»‘ nguyÃªn!");
                    return;
                }
                taiLieu = new TapChi(maTL, nxb, soBan, soPhatHanh, thangPhatHanh);
                break;
            case 3:
                System.out.print("Nháº­p ngÃ y phÃ¡t hÃ nh (1 - 31): ");
                int ngayPhatHanh;
                try {
                    ngayPhatHanh = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("NgÃ y phÃ¡t hÃ nh pháº£i lÃ  sá»‘ nguyÃªn!");
                    return;
                }
                taiLieu = new Bao(maTL, nxb, soBan, ngayPhatHanh);
                break;
            default:
                System.out.println("Loáº¡i tÃ i liá»‡u khÃ´ng há»£p lá»‡!");
                return;
        }

        boolean thanhCong = qls.themTaiLieu(taiLieu);
        if (thanhCong) {
            System.out.println(">> ThÃªm má»›i tÃ i liá»‡u thÃ nh cÃ´ng!");
        } else {
            System.out.println(">> Tháº¥t báº¡i: MÃ£ tÃ i liá»‡u '" + maTL + "' Ä‘Ã£ tá»“n táº¡i trong há»‡ thá»‘ng!");
        }
    }

    private static void xoaTaiLieu() {
        System.out.print("Nháº­p mÃ£ tÃ i liá»‡u cáº§n xÃ³a: ");
        String ma = scanner.nextLine().trim();
        boolean daXoa = qls.xoaTaiLieu(ma);
        if (daXoa) {
            System.out.println(">> ÄÃ£ xÃ³a thÃ nh cÃ´ng tÃ i liá»‡u cÃ³ mÃ£: " + ma);
        } else {
            System.out.println(">> KhÃ´ng tÃ¬m tháº¥y tÃ i liá»‡u cÃ³ mÃ£: " + ma);
        }
    }

    private static void timKiemTaiLieuTheoLoai() {
        System.out.println("Chá»n loáº¡i tÃ i liá»‡u cáº§n tÃ¬m:");
        System.out.println("1. SÃ¡ch");
        System.out.println("2. Táº¡p chÃ­");
        System.out.println("3. BÃ¡o");
        System.out.print(">> Lá»±a chá»n (1/2/3 hoáº·c tÃªn loáº¡i): ");
        String loai = scanner.nextLine().trim();
        List<TaiLieu> ketQua = qls.timKiemTheoLoai(loai);
        if (ketQua.isEmpty()) {
            System.out.println("KhÃ´ng cÃ³ tÃ i liá»‡u nÃ o thuá»™c loáº¡i Ä‘Ã£ chá»n.");
        } else {
            System.out.println("--- Káº¾T QUáº¢ TÃŒM KIáº¾M (" + ketQua.size() + ") ---");
            for (TaiLieu tl : ketQua) {
                System.out.println(tl);
            }
        }
    }
}
