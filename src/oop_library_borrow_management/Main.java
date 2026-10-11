package oop_library_borrow_management;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuanLyTheMuon qltm = new QuanLyTheMuon();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUáº¢N LÃ MÆ¯á»¢N TRáº¢ SÃCH (BÃ€I 8) ==========");
            System.out.println("1. ThÃªm má»›i tháº» mÆ°á»£n");
            System.out.println("2. XÃ³a tháº» mÆ°á»£n theo mÃ£ phiáº¿u mÆ°á»£n");
            System.out.println("3. Hiá»ƒn thá»‹ thÃ´ng tin cÃ¡c tháº» mÆ°á»£n");
            System.out.println("0. ThoÃ¡t khá»i chÆ°Æ¡ng trÃ¬nh");
            System.out.print(">> Nháº­p lá»±a chá»n cá»§a báº¡n: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiTheMuon();
                    break;
                case 2:
                    xoaTheMuon();
                    break;
                case 3:
                    qltm.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("ÄÃ£ thoÃ¡t chÆ°Æ¡ng trÃ¬nh Quáº£n lÃ½ mÆ°á»£n tráº£ sÃ¡ch.");
                    break;
                default:
                    System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡, vui lÃ²ng chá»n láº¡i!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiTheMuon() {
        System.out.print("Nháº­p mÃ£ phiáº¿u mÆ°á»£n: ");
        String maPhieu = scanner.nextLine().trim();

        System.out.print("Nháº­p há» tÃªn sinh viÃªn mÆ°á»£n sÃ¡ch: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nháº­p tuá»•i sinh viÃªn: ");
        int tuoi;
        try {
            tuoi = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tuá»•i pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        System.out.print("Nháº­p lá»›p: ");
        String lop = scanner.nextLine().trim();

        System.out.print("Nháº­p sá»‘ hiá»‡u sÃ¡ch: ");
        String soHieuSach = scanner.nextLine().trim();

        System.out.print("Nháº­p ngÃ y mÆ°á»£n (sá»‘ nguyÃªn dÆ°Æ¡ng): ");
        int ngayMuon;
        try {
            ngayMuon = Integer.parseInt(scanner.nextLine().trim());
            if (ngayMuon <= 0) {
                System.out.println("NgÃ y mÆ°á»£n pháº£i lÃ  sá»‘ nguyÃªn dÆ°Æ¡ng!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("NgÃ y mÆ°á»£n pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        System.out.print("Nháº­p háº¡n tráº£ (sá»‘ nguyÃªn dÆ°Æ¡ng): ");
        int hanTra;
        try {
            hanTra = Integer.parseInt(scanner.nextLine().trim());
            if (hanTra <= 0 || hanTra < ngayMuon) {
                System.out.println("Háº¡n tráº£ pháº£i lÃ  sá»‘ nguyÃªn dÆ°Æ¡ng vÃ  lá»›n hÆ¡n hoáº·c báº±ng ngÃ y mÆ°á»£n!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Háº¡n tráº£ pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        SinhVien sv = new SinhVien(hoTen, tuoi, lop);
        TheMuon theMuon = new TheMuon(maPhieu, ngayMuon, hanTra, soHieuSach, sv);

        boolean thanhCong = qltm.themTheMuon(theMuon);
        if (thanhCong) {
            System.out.println(">> ThÃªm má»›i tháº» mÆ°á»£n thÃ nh cÃ´ng!");
        } else {
            System.out.println(">> Tháº¥t báº¡i: MÃ£ phiáº¿u mÆ°á»£n '" + maPhieu + "' Ä‘Ã£ tá»“n táº¡i!");
        }
    }

    private static void xoaTheMuon() {
        System.out.print("Nháº­p mÃ£ phiáº¿u mÆ°á»£n cáº§n xÃ³a: ");
        String ma = scanner.nextLine().trim();
        boolean daXoa = qltm.xoaTheMuon(ma);
        if (daXoa) {
            System.out.println(">> ÄÃ£ xÃ³a thÃ nh cÃ´ng tháº» mÆ°á»£n cÃ³ mÃ£: " + ma);
        } else {
            System.out.println(">> KhÃ´ng tÃ¬m tháº¥y tháº» mÆ°á»£n cÃ³ mÃ£: " + ma);
        }
    }
}
