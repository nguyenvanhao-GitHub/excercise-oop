package oop_vehicle_management;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QLPTGT qlptgt = new QLPTGT();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== QUáº¢N LÃ PHÆ¯Æ NG TIá»†N GIAO THÃ”NG (BÃ€I 12) ==========");
            System.out.println("1. ThÃªm má»›i phÆ°Æ¡ng tiá»‡n (Ã” tÃ´, Xe mÃ¡y, Xe táº£i)");
            System.out.println("2. XÃ³a phÆ°Æ¡ng tiá»‡n theo ID");
            System.out.println("3. TÃ¬m phÆ°Æ¡ng tiá»‡n theo hÃ£ng sáº£n xuáº¥t");
            System.out.println("4. TÃ¬m phÆ°Æ¡ng tiá»‡n theo mÃ u xe");
            System.out.println("5. Hiá»ƒn thá»‹ danh sÃ¡ch phÆ°Æ¡ng tiá»‡n");
            System.out.println("0. ThoÃ¡t khá»i chÆ°Æ¡ng trÃ¬nh");
            System.out.print(">> Nháº­p lá»±a chá»n cá»§a báº¡n: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiPhuongTien();
                    break;
                case 2:
                    xoaPhuongTien();
                    break;
                case 3:
                    timTheoHangSX();
                    break;
                case 4:
                    timTheoMauXe();
                    break;
                case 5:
                    qlptgt.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("ÄÃ£ thoÃ¡t chÆ°Æ¡ng trÃ¬nh Quáº£n lÃ½ phÆ°Æ¡ng tiá»‡n giao thÃ´ng.");
                    break;
                default:
                    System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡, vui lÃ²ng chá»n láº¡i!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiPhuongTien() {
        System.out.println("\n--- Chá»n loáº¡i phÆ°Æ¡ng tiá»‡n ---");
        System.out.println("1. Ã” tÃ´");
        System.out.println("2. Xe mÃ¡y");
        System.out.println("3. Xe táº£i");
        System.out.print(">> Lá»±a chá»n: ");
        int loai;
        try {
            loai = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡!");
            return;
        }

        System.out.print("Nháº­p ID phÆ°Æ¡ng tiá»‡n: ");
        String id = scanner.nextLine().trim();

        System.out.print("Nháº­p hÃ£ng sáº£n xuáº¥t: ");
        String hangSX = scanner.nextLine().trim();

        System.out.print("Nháº­p nÄƒm sáº£n xuáº¥t: ");
        int namSX;
        try {
            namSX = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("NÄƒm sáº£n xuáº¥t pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        System.out.print("Nháº­p giÃ¡ bÃ¡n: ");
        double giaBan;
        try {
            giaBan = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("GiÃ¡ bÃ¡n pháº£i lÃ  sá»‘!");
            return;
        }

        System.out.print("Nháº­p mÃ u xe: ");
        String mauXe = scanner.nextLine().trim();

        PhuongTien pt;
        switch (loai) {
            case 1:
                System.out.print("Nháº­p sá»‘ chá»— ngá»“i: ");
                int soCho;
                try {
                    soCho = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Sá»‘ chá»— ngá»“i pháº£i lÃ  sá»‘ nguyÃªn!");
                    return;
                }
                System.out.print("Nháº­p kiá»ƒu Ä‘á»™ng cÆ¡: ");
                String dongCo = scanner.nextLine().trim();
                pt = new Oto(id, hangSX, namSX, giaBan, mauXe, soCho, dongCo);
                break;
            case 2:
                System.out.print("Nháº­p cÃ´ng suáº¥t (HP): ");
                double congSuat;
                try {
                    congSuat = Double.parseDouble(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("CÃ´ng suáº¥t pháº£i lÃ  sá»‘!");
                    return;
                }
                pt = new XeMay(id, hangSX, namSX, giaBan, mauXe, congSuat);
                break;
            case 3:
                System.out.print("Nháº­p trá»ng táº£i (táº¥n): ");
                double trongTai;
                try {
                    trongTai = Double.parseDouble(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Trá»ng táº£i pháº£i lÃ  sá»‘!");
                    return;
                }
                pt = new XeTai(id, hangSX, namSX, giaBan, mauXe, trongTai);
                break;
            default:
                System.out.println("Loáº¡i phÆ°Æ¡ng tiá»‡n khÃ´ng há»£p lá»‡!");
                return;
        }

        boolean thanhCong = qlptgt.themPhuongTien(pt);
        if (thanhCong) {
            System.out.println(">> ThÃªm má»›i phÆ°Æ¡ng tiá»‡n thÃ nh cÃ´ng!");
        } else {
            System.out.println(">> Tháº¥t báº¡i: ID '" + id + "' Ä‘Ã£ tá»“n táº¡i trong há»‡ thá»‘ng!");
        }
    }

    private static void xoaPhuongTien() {
        System.out.print("Nháº­p ID phÆ°Æ¡ng tiá»‡n cáº§n xÃ³a: ");
        String id = scanner.nextLine().trim();
        boolean daXoa = qlptgt.xoaPhuongTien(id);
        if (daXoa) {
            System.out.println(">> ÄÃ£ xÃ³a thÃ nh cÃ´ng phÆ°Æ¡ng tiá»‡n cÃ³ ID: " + id);
        } else {
            System.out.println(">> KhÃ´ng tÃ¬m tháº¥y phÆ°Æ¡ng tiá»‡n cÃ³ ID: " + id);
        }
    }

    private static void timTheoHangSX() {
        System.out.print("Nháº­p hÃ£ng sáº£n xuáº¥t cáº§n tÃ¬m: ");
        String hang = scanner.nextLine().trim();
        List<PhuongTien> ketQua = qlptgt.timKiemTheoHangSanXuat(hang);
        if (ketQua.isEmpty()) {
            System.out.println("KhÃ´ng tÃ¬m tháº¥y phÆ°Æ¡ng tiá»‡n nÃ o cá»§a hÃ£ng: " + hang);
        } else {
            System.out.println("--- Káº¾T QUáº¢ TÃŒM KIáº¾M THEO HÃƒNG (" + ketQua.size() + ") ---");
            for (PhuongTien p : ketQua) {
                System.out.println(p);
            }
        }
    }

    private static void timTheoMauXe() {
        System.out.print("Nháº­p mÃ u xe cáº§n tÃ¬m: ");
        String mau = scanner.nextLine().trim();
        List<PhuongTien> ketQua = qlptgt.timKiemTheoMau(mau);
        if (ketQua.isEmpty()) {
            System.out.println("KhÃ´ng tÃ¬m tháº¥y phÆ°Æ¡ng tiá»‡n nÃ o cÃ³ mÃ u: " + mau);
        } else {
            System.out.println("--- Káº¾T QUáº¢ TÃŒM KIáº¾M THEO MÃ€U (" + ketQua.size() + ") ---");
            for (PhuongTien p : ketQua) {
                System.out.println(p);
            }
        }
    }
}
