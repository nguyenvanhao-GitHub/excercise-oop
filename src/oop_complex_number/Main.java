package oop_complex_number;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========== CHÆ¯Æ NG TRÃŒNH Sá» PHá»¨C (BÃ€I 11) ==========");

        SoPhuc sp1 = new SoPhuc();
        System.out.println("Nháº­p sá»‘ phá»©c thá»© nháº¥t:");
        sp1.nhap(scanner);

        SoPhuc sp2 = new SoPhuc();
        System.out.println("Nháº­p sá»‘ phá»©c thá»© hai:");
        sp2.nhap(scanner);

        System.out.println("\n--- CÃC Sá» PHá»¨C Vá»ªA NHáº¬P ---");
        System.out.print("Sá»‘ phá»©c 1: ");
        sp1.hienThi();
        System.out.print("Sá»‘ phá»©c 2: ");
        sp2.hienThi();

        System.out.println("\n--- Káº¾T QUáº¢ PHÃ‰P TOÃN ---");
        SoPhuc tong = sp1.cong(sp2);
        System.out.println("Tá»•ng (sp1 + sp2) = " + tong);

        SoPhuc tich = sp1.nhan(sp2);
        System.out.println("TÃ­ch (sp1 * sp2) = " + tich);
    }
}
