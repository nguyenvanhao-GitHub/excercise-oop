package b4;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        KhuPho khuPho = new KhuPho();

        System.out.println("========== QUẢN LÝ KHU PHỐ (BÀI 4) ==========");
        System.out.print("Nhập số lượng hộ dân trong khu phố (n): ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println("Số hộ dân phải lớn hơn 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Số lượng hộ dân phải là số nguyên!");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập thông tin hộ gia đình thứ " + (i + 1) + " ---");
            System.out.print("Nhập số nhà: ");
            String soNha = scanner.nextLine().trim();

            System.out.print("Nhập số thành viên trong gia đình: ");
            int soThanhVien;
            try {
                soThanhVien = Integer.parseInt(scanner.nextLine().trim());
                if (soThanhVien <= 0) {
                    System.out.println("Số thành viên phải lớn hơn 0!");
                    i--;
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Số thành viên phải là số nguyên!");
                i--;
                continue;
            }

            HoGiaDinh hoGiaDinh = new HoGiaDinh();
            hoGiaDinh.setSoNha(soNha);

            for (int j = 0; j < soThanhVien; j++) {
                System.out.println("  > Nhập thông tin thành viên thứ " + (j + 1) + ":");
                System.out.print("    Nhập số CMND (duy nhất): ");
                String cmnd = scanner.nextLine().trim();

                System.out.print("    Nhập họ tên: ");
                String hoTen = scanner.nextLine().trim();

                System.out.print("    Nhập tuổi: ");
                int tuoi;
                try {
                    tuoi = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("    Tuổi phải là số nguyên!");
                    j--;
                    continue;
                }

                System.out.print("    Nhập nghề nghiệp: ");
                String ngheNghiep = scanner.nextLine().trim();

                hoGiaDinh.themThanhVien(new Nguoi(hoTen, tuoi, ngheNghiep, cmnd));
            }

            khuPho.themHoGiaDinh(hoGiaDinh);
        }

        System.out.println("\n");
        khuPho.hienThiThongTin();
    }
}
