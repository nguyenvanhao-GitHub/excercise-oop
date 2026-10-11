package oop_hotel_management;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final KhachSan khachSan = new KhachSan();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUáº¢N LÃ KHÃCH Sáº N (BÃ€I 5) ==========");
            System.out.println("1. ThÃªm má»›i khÃ¡ch thuÃª phÃ²ng");
            System.out.println("2. XÃ³a khÃ¡ch thuÃª theo sá»‘ CMND");
            System.out.println("3. TÃ­nh tiá»n thuÃª phÃ²ng theo sá»‘ CMND");
            System.out.println("4. Hiá»ƒn thá»‹ danh sÃ¡ch khÃ¡ch thuÃª phÃ²ng");
            System.out.println("0. ThoÃ¡t khá»i chÆ°Æ¡ng trÃ¬nh");
            System.out.print(">> Nháº­p lá»±a chá»n cá»§a báº¡n: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiKhachThue();
                    break;
                case 2:
                    xoaKhachThue();
                    break;
                case 3:
                    tinhTienThue();
                    break;
                case 4:
                    khachSan.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("ÄÃ£ thoÃ¡t chÆ°Æ¡ng trÃ¬nh Quáº£n lÃ½ khÃ¡ch sáº¡n.");
                    break;
                default:
                    System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡, vui lÃ²ng chá»n láº¡i!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiKhachThue() {
        System.out.print("Nháº­p há» tÃªn khÃ¡ch hÃ ng: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nháº­p tuá»•i: ");
        int tuoi;
        try {
            tuoi = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tuá»•i pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        System.out.print("Nháº­p sá»‘ CMND: ");
        String cmnd = scanner.nextLine().trim();

        System.out.println("Chá»n loáº¡i phÃ²ng thuÃª:");
        System.out.println("1. Loáº¡i A (500$/ngÃ y)");
        System.out.println("2. Loáº¡i B (300$/ngÃ y)");
        System.out.println("3. Loáº¡i C (100$/ngÃ y)");
        System.out.print(">> Chá»n loáº¡i phÃ²ng (1/2/3 hoáº·c A/B/C): ");
        String chonPhong = scanner.nextLine().trim().toUpperCase();

        Phong phong;
        if (chonPhong.equals("1") || chonPhong.equals("A")) {
            phong = new PhongA();
        } else if (chonPhong.equals("2") || chonPhong.equals("B")) {
            phong = new PhongB();
        } else if (chonPhong.equals("3") || chonPhong.equals("C")) {
            phong = new PhongC();
        } else {
            System.out.println("Loáº¡i phÃ²ng khÃ´ng há»£p lá»‡!");
            return;
        }

        System.out.print("Nháº­p sá»‘ ngÃ y thuÃª: ");
        int soNgay;
        try {
            soNgay = Integer.parseInt(scanner.nextLine().trim());
            if (soNgay <= 0) {
                System.out.println("Sá»‘ ngÃ y thuÃª pháº£i lá»›n hÆ¡n 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Sá»‘ ngÃ y thuÃª pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        Nguoi nguoi = new Nguoi(hoTen, tuoi, cmnd);
        KhachThue khachThue = new KhachThue(nguoi, phong, soNgay);

        boolean thanhCong = khachSan.themKhachThue(khachThue);
        if (thanhCong) {
            System.out.println(">> ThÃªm má»›i khÃ¡ch thuÃª thÃ nh cÃ´ng!");
        } else {
            System.out.println(">> Tháº¥t báº¡i: KhÃ¡ch hÃ ng vá»›i sá»‘ CMND '" + cmnd + "' Ä‘ang thuÃª phÃ²ng!");
        }
    }

    private static void xoaKhachThue() {
        System.out.print("Nháº­p sá»‘ CMND khÃ¡ch cáº§n tráº£ phÃ²ng/xÃ³a: ");
        String cmnd = scanner.nextLine().trim();
        boolean daXoa = khachSan.xoaKhachThue(cmnd);
        if (daXoa) {
            System.out.println(">> ÄÃ£ xÃ³a khÃ¡ch hÃ ng cÃ³ sá»‘ CMND: " + cmnd);
        } else {
            System.out.println(">> KhÃ´ng tÃ¬m tháº¥y khÃ¡ch hÃ ng cÃ³ sá»‘ CMND: " + cmnd);
        }
    }

    private static void tinhTienThue() {
        System.out.print("Nháº­p sá»‘ CMND cá»§a khÃ¡ch Ä‘á»ƒ thanh toÃ¡n: ");
        String cmnd = scanner.nextLine().trim();
        Double tongTien = khachSan.tinhTienThuePhong(cmnd);
        if (tongTien != null) {
            System.out.println(">> Tá»•ng tiá»n thuÃª phÃ²ng cá»§a khÃ¡ch hÃ ng [CMND: " + cmnd + "] lÃ : " + tongTien + " $");
        } else {
            System.out.println(">> KhÃ´ng tÃ¬m tháº¥y khÃ¡ch hÃ ng cÃ³ sá»‘ CMND: " + cmnd);
        }
    }
}
