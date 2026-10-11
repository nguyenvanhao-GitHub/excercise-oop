package oop_school_management;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuanLyHocSinh qlhs = new QuanLyHocSinh();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUáº¢N LÃ Há»’ SÆ  Há»ŒC SINH THPT (BÃ€I 6) ==========");
            System.out.println("1. ThÃªm há»c sinh má»›i");
            System.out.println("2. Hiá»ƒn thá»‹ toÃ n bá»™ danh sÃ¡ch há»c sinh");
            System.out.println("3. Hiá»ƒn thá»‹ cÃ¡c há»c sinh 20 tuá»•i");
            System.out.println("4. Äáº¿m sá»‘ lÆ°á»£ng há»c sinh 23 tuá»•i vÃ  quÃª á»Ÿ DN");
            System.out.println("0. ThoÃ¡t khá»i chÆ°Æ¡ng trÃ¬nh");
            System.out.print(">> Nháº­p lá»±a chá»n cá»§a báº¡n: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themHocSinhMoi();
                    break;
                case 2:
                    qlhs.hienThiDanhSach();
                    break;
                case 3:
                    hienThiHocSinh20Tuoi();
                    break;
                case 4:
                    demHocSinh23TuoiDN();
                    break;
                case 0:
                    System.out.println("ÄÃ£ thoÃ¡t chÆ°Æ¡ng trÃ¬nh Quáº£n lÃ½ há»c sinh.");
                    break;
                default:
                    System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡, vui lÃ²ng chá»n láº¡i!");
            }
        } while (luaChon != 0);
    }

    private static void themHocSinhMoi() {
        System.out.print("Nháº­p há» tÃªn há»c sinh: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nháº­p tuá»•i: ");
        int tuoi;
        try {
            tuoi = Integer.parseInt(scanner.nextLine().trim());
            if (tuoi <= 0) {
                System.out.println("Tuá»•i pháº£i lá»›n hÆ¡n 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Tuá»•i pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        System.out.print("Nháº­p quÃª quÃ¡n: ");
        String queQuan = scanner.nextLine().trim();

        System.out.print("Nháº­p lá»›p: ");
        String lop = scanner.nextLine().trim();

        qlhs.themHocSinh(new HocSinh(hoTen, tuoi, queQuan, lop));
        System.out.println(">> ThÃªm há»c sinh thÃ nh cÃ´ng!");
    }

    private static void hienThiHocSinh20Tuoi() {
        List<HocSinh> ds20 = qlhs.timHocSinh20Tuoi();
        if (ds20.isEmpty()) {
            System.out.println("KhÃ´ng cÃ³ há»c sinh nÃ o 20 tuá»•i.");
        } else {
            System.out.println("----- DANH SÃCH Há»ŒC SINH 20 TUá»”I (" + ds20.size() + ") -----");
            for (HocSinh hs : ds20) {
                System.out.println(hs);
            }
        }
    }

    private static void demHocSinh23TuoiDN() {
        long dem = qlhs.demHocSinh23TuoiQueDN();
        System.out.println(">> Sá»‘ lÆ°á»£ng há»c sinh 23 tuá»•i vÃ  cÃ³ quÃª á»Ÿ DN (ÄÃ  Náºµng): " + dem);
    }
}
