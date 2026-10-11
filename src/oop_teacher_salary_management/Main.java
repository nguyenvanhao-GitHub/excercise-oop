package oop_teacher_salary_management;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QuanLyCBGV quanLy = new QuanLyCBGV();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUáº¢N LÃ LÆ¯Æ NG CÃN Bá»˜ GIÃO VIÃŠN (BÃ€I 7) ==========");
            System.out.println("1. ThÃªm cÃ¡n bá»™ giÃ¡o viÃªn");
            System.out.println("2. XÃ³a cÃ¡n bá»™ giÃ¡o viÃªn theo mÃ£ sá»‘ GV");
            System.out.println("3. Hiá»ƒn thá»‹ danh sÃ¡ch cÃ¡n bá»™ giÃ¡o viÃªn & lÆ°Æ¡ng thá»±c lÄ©nh");
            System.out.println("0. ThoÃ¡t khá»i chÆ°Æ¡ng trÃ¬nh");
            System.out.print(">> Nháº­p lá»±a chá»n cá»§a báº¡n: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themCBGV();
                    break;
                case 2:
                    xoaCBGV();
                    break;
                case 3:
                    quanLy.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("ÄÃ£ thoÃ¡t chÆ°Æ¡ng trÃ¬nh Quáº£n lÃ½ lÆ°Æ¡ng cÃ¡n bá»™ giÃ¡o viÃªn.");
                    break;
                default:
                    System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡, vui lÃ²ng chá»n láº¡i!");
            }
        } while (luaChon != 0);
    }

    private static void themCBGV() {
        System.out.print("Nháº­p mÃ£ sá»‘ giÃ¡o viÃªn: ");
        String msgv = scanner.nextLine().trim();

        System.out.print("Nháº­p há» tÃªn giÃ¡o viÃªn: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nháº­p tuá»•i: ");
        int tuoi;
        try {
            tuoi = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tuá»•i pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        System.out.print("Nháº­p quÃª quÃ¡n: ");
        String queQuan = scanner.nextLine().trim();

        System.out.print("Nháº­p lÆ°Æ¡ng cá»©ng: ");
        double luongCung;
        try {
            luongCung = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("LÆ°Æ¡ng cá»©ng pháº£i lÃ  sá»‘!");
            return;
        }

        System.out.print("Nháº­p lÆ°Æ¡ng thÆ°á»Ÿng: ");
        double luongThuong;
        try {
            luongThuong = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("LÆ°Æ¡ng thÆ°á»Ÿng pháº£i lÃ  sá»‘!");
            return;
        }

        System.out.print("Nháº­p tiá»n pháº¡t: ");
        double tienPhat;
        try {
            tienPhat = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tiá»n pháº¡t pháº£i lÃ  sá»‘!");
            return;
        }

        CBGV cbgv = new CBGV(hoTen, tuoi, queQuan, msgv, luongCung, luongThuong, tienPhat);
        boolean thanhCong = quanLy.themCBGV(cbgv);
        if (thanhCong) {
            System.out.println(">> ThÃªm cÃ¡n bá»™ giÃ¡o viÃªn thÃ nh cÃ´ng!");
        } else {
            System.out.println(">> Tháº¥t báº¡i: MÃ£ sá»‘ giÃ¡o viÃªn '" + msgv + "' Ä‘Ã£ tá»“n táº¡i!");
        }
    }

    private static void xoaCBGV() {
        System.out.print("Nháº­p mÃ£ sá»‘ giÃ¡o viÃªn cáº§n xÃ³a: ");
        String msgv = scanner.nextLine().trim();
        boolean daXoa = quanLy.xoaCBGV(msgv);
        if (daXoa) {
            System.out.println(">> ÄÃ£ xÃ³a cÃ¡n bá»™ giÃ¡o viÃªn cÃ³ mÃ£ sá»‘: " + msgv);
        } else {
            System.out.println(">> KhÃ´ng tÃ¬m tháº¥y cÃ¡n bá»™ giÃ¡o viÃªn cÃ³ mÃ£ sá»‘: " + msgv);
        }
    }
}
