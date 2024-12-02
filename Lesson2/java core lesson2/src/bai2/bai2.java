package bai2;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
//        Nhập 2 số a và b, Giải phương trình bậc 1
        Scanner sc = new Scanner(System.in);
        double a, b;
        System.out.println("Nhập a: ");
        a = sc.nextDouble();
        System.out.println("Nhập b: ");
        b = sc.nextDouble();
        double x;
        if (a == 0 && b != 0) {
            System.out.println("Phương trình vô nghiệm");
        } else if (a == 0 && b == 0) {
            System.out.println("Phương trình vô số nghiệm");
        } else {
            x = -b / a;
            System.out.println("Phương trình có nghiệm duy nhất x = " + x);
        }

    }
}
