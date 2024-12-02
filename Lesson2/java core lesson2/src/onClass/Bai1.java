package onClass;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
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
