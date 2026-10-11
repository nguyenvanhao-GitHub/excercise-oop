package b11;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========== CHƯƠNG TRÌNH SỐ PHỨC (BÀI 11) ==========");

        SoPhuc sp1 = new SoPhuc();
        System.out.println("Nhập số phức thứ nhất:");
        sp1.nhap(scanner);

        SoPhuc sp2 = new SoPhuc();
        System.out.println("Nhập số phức thứ hai:");
        sp2.nhap(scanner);

        System.out.println("\n--- CÁC SỐ PHỨC VỪA NHẬP ---");
        System.out.print("Số phức 1: ");
        sp1.hienThi();
        System.out.print("Số phức 2: ");
        sp2.hienThi();

        System.out.println("\n--- KẾT QUẢ PHÉP TOÁN ---");
        SoPhuc tong = sp1.cong(sp2);
        System.out.println("Tổng (sp1 + sp2) = " + tong);

        SoPhuc tich = sp1.nhan(sp2);
        System.out.println("Tích (sp1 * sp2) = " + tich);
    }
}
