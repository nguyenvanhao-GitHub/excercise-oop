package oop_officer_management;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final QLCB qlcb = new QLCB();

    public static void main(String[] args) {
        int luaChon;
        do {
            System.out.println("\n========== CHÆ¯Æ NG TRÃŒNH QUáº¢N LÃ CÃN Bá»˜ (BÃ€I 1) ==========");
            System.out.println("1. ThÃªm má»›i cÃ¡n bá»™ (CÃ´ng nhÃ¢n, Ká»¹ sÆ°, NhÃ¢n viÃªn)");
            System.out.println("2. TÃ¬m kiáº¿m cÃ¡n bá»™ theo há» tÃªn");
            System.out.println("3. Hiá»ƒn thá»‹ thÃ´ng tin danh sÃ¡ch cÃ¡n bá»™");
            System.out.println("0. ThoÃ¡t khá»i chÆ°Æ¡ng trÃ¬nh");
            System.out.print(">> Nháº­p lá»±a chá»n cá»§a báº¡n: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                luaChon = -1;
            }

            switch (luaChon) {
                case 1:
                    themMoiCanBo();
                    break;
                case 2:
                    timKiemCanBo();
                    break;
                case 3:
                    qlcb.hienThiDanhSach();
                    break;
                case 0:
                    System.out.println("ÄÃ£ thoÃ¡t chÆ°Æ¡ng trÃ¬nh Quáº£n lÃ½ cÃ¡n bá»™.");
                    break;
                default:
                    System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡, vui lÃ²ng chá»n láº¡i!");
            }
        } while (luaChon != 0);
    }

    private static void themMoiCanBo() {
        System.out.println("\n--- Chá»n loáº¡i cÃ¡n bá»™ muá»‘n thÃªm ---");
        System.out.println("1. CÃ´ng nhÃ¢n");
        System.out.println("2. Ká»¹ sÆ°");
        System.out.println("3. NhÃ¢n viÃªn");
        System.out.print(">> Lá»±a chá»n: ");
        int loai;
        try {
            loai = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lá»±a chá»n khÃ´ng há»£p lá»‡!");
            return;
        }

        System.out.print("Nháº­p há» tÃªn: ");
        String hoTen = scanner.nextLine().trim();

        System.out.print("Nháº­p tuá»•i: ");
        int tuoi;
        try {
            tuoi = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Tuá»•i pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        System.out.print("Nháº­p giá»›i tÃ­nh (Nam/Ná»¯/KhÃ¡c): ");
        String gioiTinh = scanner.nextLine().trim();

        System.out.print("Nháº­p Ä‘á»‹a chá»‰: ");
        String diaChi = scanner.nextLine().trim();

        switch (loai) {
            case 1:
                System.out.print("Nháº­p báº­c (1 - 10): ");
                int bac;
                try {
                    bac = Integer.parseInt(scanner.nextLine().trim());
                    if (bac < 1 || bac > 10) {
                        System.out.println("Báº­c pháº£i tá»« 1 Ä‘áº¿n 10!");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Báº­c pháº£i lÃ  sá»‘!");
                    return;
                }
                qlcb.themCanBo(new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac));
                System.out.println(">> ThÃªm cÃ´ng nhÃ¢n thÃ nh cÃ´ng!");
                break;
            case 2:
                System.out.print("Nháº­p ngÃ nh Ä‘Ã o táº¡o: ");
                String nganh = scanner.nextLine().trim();
                qlcb.themCanBo(new KySu(hoTen, tuoi, gioiTinh, diaChi, nganh));
                System.out.println(">> ThÃªm ká»¹ sÆ° thÃ nh cÃ´ng!");
                break;
            case 3:
                System.out.print("Nháº­p cÃ´ng viá»‡c: ");
                String congViec = scanner.nextLine().trim();
                qlcb.themCanBo(new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec));
                System.out.println(">> ThÃªm nhÃ¢n viÃªn thÃ nh cÃ´ng!");
                break;
            default:
                System.out.println("Loáº¡i cÃ¡n bá»™ khÃ´ng há»£p lá»‡!");
        }
    }

    private static void timKiemCanBo() {
        System.out.print("Nháº­p há» tÃªn cáº§n tÃ¬m kiáº¿m: ");
        String hoTen = scanner.nextLine().trim();
        List<CanBo> ketQua = qlcb.timKiemTheoHoTen(hoTen);
        if (ketQua.isEmpty()) {
            System.out.println("KhÃ´ng tÃ¬m tháº¥y cÃ¡n bá»™ nÃ o cÃ³ tÃªn chá»©a: " + hoTen);
        } else {
            System.out.println("--- Káº¿t quáº£ tÃ¬m kiáº¿m (" + ketQua.size() + ") ---");
            for (CanBo cb : ketQua) {
                System.out.println(cb);
            }
        }
    }
}
