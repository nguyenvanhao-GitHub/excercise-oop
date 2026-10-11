package oop_complex_number;

import java.util.Scanner;

public class SoPhuc {
    private double phanThuc;
    private double phanAo;

    // YÃªu cáº§u 1: PhÆ°Æ¡ng thá»©c táº¡o láº­p
    public SoPhuc() {
        this.phanThuc = 0;
        this.phanAo = 0;
    }

    public SoPhuc(double phanThuc, double phanAo) {
        this.phanThuc = phanThuc;
        this.phanAo = phanAo;
    }

    public double getPhanThuc() {
        return phanThuc;
    }

    public void setPhanThuc(double phanThuc) {
        this.phanThuc = phanThuc;
    }

    public double getPhanAo() {
        return phanAo;
    }

    public void setPhanAo(double phanAo) {
        this.phanAo = phanAo;
    }

    // YÃªu cáº§u 2: Nháº­p má»™t sá»‘ phá»©c
    public void nhap(Scanner scanner) {
        System.out.print("  Nháº­p pháº§n thá»±c: ");
        this.phanThuc = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("  Nháº­p pháº§n áº£o: ");
        this.phanAo = Double.parseDouble(scanner.nextLine().trim());
    }

    // YÃªu cáº§u 2: Hiá»ƒn thá»‹ sá»‘ phá»©c
    public void hienThi() {
        System.out.println(this.toString());
    }

    // YÃªu cáº§u 2: Cá»™ng 2 sá»‘ phá»©c: (a + bi) + (c + di) = (a + c) + (b + d)i
    public SoPhuc cong(SoPhuc sp2) {
        if (sp2 == null) return this;
        double thuc = this.phanThuc + sp2.phanThuc;
        double ao = this.phanAo + sp2.phanAo;
        return new SoPhuc(thuc, ao);
    }

    // YÃªu cáº§u 2: NhÃ¢n 2 sá»‘ phá»©c: (a + bi)(c + di) = (ac - bd) + (ad + bc)i
    public SoPhuc nhan(SoPhuc sp2) {
        if (sp2 == null) return new SoPhuc(0, 0);
        double thuc = this.phanThuc * sp2.phanThuc - this.phanAo * sp2.phanAo;
        double ao = this.phanThuc * sp2.phanAo + this.phanAo * sp2.phanThuc;
        return new SoPhuc(thuc, ao);
    }

    @Override
    public String toString() {
        if (phanAo == 0) {
            return String.valueOf(phanThuc);
        }
        if (phanThuc == 0) {
            return phanAo + "i";
        }
        if (phanAo > 0) {
            return phanThuc + " + " + phanAo + "i";
        } else {
            return phanThuc + " - " + Math.abs(phanAo) + "i";
        }
    }
}
