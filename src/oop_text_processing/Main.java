package oop_text_processing;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========== XỬ LÝ VĂN BẢN (BÀI 10) ==========");
        System.out.print("Nhập một đoạn văn bản: ");
        String chuoi = scanner.nextLine();

        VanBan vanBan = new VanBan(chuoi);

        System.out.println("\n--- THÔNG TIN VĂN BẢN BAN ĐẦU ---");
        System.out.println("Nội dung: \"" + vanBan.getNoiDung() + "\"");
        System.out.println("Số lượng từ: " + vanBan.demSoTu());
        System.out.println("Số lượng ký tự 'A' hoặc 'a': " + vanBan.demKyTuA());

        System.out.println("\n--- SAU KHI CHUẨN HOÁ VĂN BẢN ---");
        String daChuanHoa = vanBan.chuanHoa();
        System.out.println("Nội dung chuẩn hoá: \"" + daChuanHoa + "\"");
        System.out.println("Số lượng từ sau chuẩn hoá: " + vanBan.demSoTu());
        System.out.println("Số lượng ký tự 'A' hoặc 'a' sau chuẩn hoá: " + vanBan.demKyTuA());
    }
}
