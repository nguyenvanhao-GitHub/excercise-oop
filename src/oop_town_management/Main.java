package oop_town_management;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        KhuPho khuPho = new KhuPho();

        System.out.println("========== QUáº¢N LÃ KHU PHá» (BÃ€I 4) ==========");
        System.out.print("Nháº­p sá»‘ lÆ°á»£ng há»™ dÃ¢n trong khu phá»‘ (n): ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println("Sá»‘ há»™ dÃ¢n pháº£i lá»›n hÆ¡n 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Sá»‘ lÆ°á»£ng há»™ dÃ¢n pháº£i lÃ  sá»‘ nguyÃªn!");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nháº­p thÃ´ng tin há»™ gia Ä‘Ã¬nh thá»© " + (i + 1) + " ---");
            System.out.print("Nháº­p sá»‘ nhÃ : ");
            String soNha = scanner.nextLine().trim();

            System.out.print("Nháº­p sá»‘ thÃ nh viÃªn trong gia Ä‘Ã¬nh: ");
            int soThanhVien;
            try {
                soThanhVien = Integer.parseInt(scanner.nextLine().trim());
                if (soThanhVien <= 0) {
                    System.out.println("Sá»‘ thÃ nh viÃªn pháº£i lá»›n hÆ¡n 0!");
                    i--;
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Sá»‘ thÃ nh viÃªn pháº£i lÃ  sá»‘ nguyÃªn!");
                i--;
                continue;
            }

            HoGiaDinh hoGiaDinh = new HoGiaDinh();
            hoGiaDinh.setSoNha(soNha);

            for (int j = 0; j < soThanhVien; j++) {
                System.out.println("  > Nháº­p thÃ´ng tin thÃ nh viÃªn thá»© " + (j + 1) + ":");
                System.out.print("    Nháº­p sá»‘ CMND (duy nháº¥t): ");
                String cmnd = scanner.nextLine().trim();

                System.out.print("    Nháº­p há» tÃªn: ");
                String hoTen = scanner.nextLine().trim();

                System.out.print("    Nháº­p tuá»•i: ");
                int tuoi;
                try {
                    tuoi = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("    Tuá»•i pháº£i lÃ  sá»‘ nguyÃªn!");
                    j--;
                    continue;
                }

                System.out.print("    Nháº­p nghá» nghiá»‡p: ");
                String ngheNghiep = scanner.nextLine().trim();

                hoGiaDinh.themThanhVien(new Nguoi(hoTen, tuoi, ngheNghiep, cmnd));
            }

            khuPho.themHoGiaDinh(hoGiaDinh);
        }

        System.out.println("\n");
        khuPho.hienThiThongTin();
    }
}
