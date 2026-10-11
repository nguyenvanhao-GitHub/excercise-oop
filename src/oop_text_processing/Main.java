package oop_text_processing;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========== Xá»¬ LÃ VÄ‚N Báº¢N (BÃ€I 10) ==========");
        System.out.print("Nháº­p má»™t Ä‘oáº¡n vÄƒn báº£n: ");
        String chuoi = scanner.nextLine();

        VanBan vanBan = new VanBan(chuoi);

        System.out.println("\n--- THÃ”NG TIN VÄ‚N Báº¢N BAN Äáº¦U ---");
        System.out.println("Ná»™i dung: \"" + vanBan.getNoiDung() + "\"");
        System.out.println("Sá»‘ lÆ°á»£ng tá»«: " + vanBan.demSoTu());
        System.out.println("Sá»‘ lÆ°á»£ng kÃ½ tá»± 'A' hoáº·c 'a': " + vanBan.demKyTuA());

        System.out.println("\n--- SAU KHI CHUáº¨N HOÃ VÄ‚N Báº¢N ---");
        String daChuanHoa = vanBan.chuanHoa();
        System.out.println("Ná»™i dung chuáº©n hoÃ¡: \"" + daChuanHoa + "\"");
        System.out.println("Sá»‘ lÆ°á»£ng tá»« sau chuáº©n hoÃ¡: " + vanBan.demSoTu());
        System.out.println("Sá»‘ lÆ°á»£ng kÃ½ tá»± 'A' hoáº·c 'a' sau chuáº©n hoÃ¡: " + vanBan.demKyTuA());
    }
}
