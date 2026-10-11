package oop_admission_management;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TuyenSinh tuyenSinh = new TuyenSinh();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUáº¢N LÃ TUYá»‚N SINH Äáº I Há»ŒC (BÃ€I 3) ==========");
            System.out.println("1. ThÃªm má»›i thÃ­ sinh (Khá»‘i A, Khá»‘i B, Khá»‘i C)");
            System.out.println("2. Hiá»ƒn thá»‹ thÃ´ng tin vÃ  khá»‘i thi cá»§a thÃ­ sinh");
            System.out.println("3. TÃ¬m kiáº¿m thÃ­ sinh theo sá»‘ bÃ¡o danh");
            System.out.println("0. ThoÃ¡t khá»i chÆ°Æ¡ng trÃ¬nh");
            System.out.print(">> Nháº­p lá»±a chá»n cá»§a báº¡n: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiThiSinh();
                    break;
                case 2:
                    tuyenSinh.hienThiThongTin();
                    break;
                case 3:
                    timKiemThiSinh();
                    break;
                case 0:
                    System.out.println("ÄÃ£ thoÃ¡t chÆ°Æ¡ng trÃ¬nh Quáº£n lÃ½ tuyá»ƒn sinh.");
                    break;
                default:
                    System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡, vui lÃ²ng chá»n láº¡i!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiThiSinh() {
        System.out.println("\n--- Chá»n khá»‘i thi ---");
        System.out.println("1. Khá»‘i A (ToÃ¡n, LÃ½, HoÃ¡)");
        System.out.println("2. Khá»‘i B (ToÃ¡n, HoÃ¡, Sinh)");
        System.out.println("3. Khá»‘i C (VÄƒn, Sá»­, Äá»‹a)");
        System.out.print(">> Lá»±a chá»n: ");
        int loai;
        try {
            loai = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡!");
            return;
        }

        System.out.print("Nháº­p sá»‘ bÃ¡o danh: ");
        String sbd = scanner.nextLine().trim();

        System.out.print("Nháº­p há» tÃªn: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nháº­p Ä‘á»‹a chá»‰: ");
        String diaChi = scanner.nextLine().trim();

        System.out.print("Nháº­p má»©c Æ°u tiÃªn: ");
        int mucUuTien;
        try {
            mucUuTien = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Má»©c Æ°u tiÃªn pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        ThiSinh thiSinh;
        switch (loai) {
            case 1:
                thiSinh = new ThiSinhKhoiA(sbd, hoTen, diaChi, mucUuTien);
                break;
            case 2:
                thiSinh = new ThiSinhKhoiB(sbd, hoTen, diaChi, mucUuTien);
                break;
            case 3:
                thiSinh = new ThiSinhKhoiC(sbd, hoTen, diaChi, mucUuTien);
                break;
            default:
                System.out.println("Khá»‘i thi khÃ´ng há»£p lá»‡!");
                return;
        }

        boolean thanhCong = tuyenSinh.themThiSinh(thiSinh);
        if (thanhCong) {
            System.out.println(">> ThÃªm má»›i thÃ­ sinh thÃ nh cÃ´ng!");
        } else {
            System.out.println(">> Tháº¥t báº¡i: Sá»‘ bÃ¡o danh '" + sbd + "' Ä‘Ã£ tá»“n táº¡i!");
        }
    }

    private static void timKiemThiSinh() {
        System.out.print("Nháº­p sá»‘ bÃ¡o danh cáº§n tÃ¬m: ");
        String sbd = scanner.nextLine().trim();
        ThiSinh thiSinh = tuyenSinh.timKiemTheoSoBaoDanh(sbd);
        if (thiSinh != null) {
            System.out.println(">> ÄÃ£ tÃ¬m tháº¥y thÃ­ sinh:");
            System.out.println(thiSinh);
        } else {
            System.out.println(">> KhÃ´ng tÃ¬m tháº¥y thÃ­ sinh cÃ³ sá»‘ bÃ¡o danh: " + sbd);
        }
    }
}
