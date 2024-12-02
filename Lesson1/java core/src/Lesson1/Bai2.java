package Lesson1;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        int a , b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a: ");
        a = sc.nextInt();
        System.out.println("Nhập b: ");
        b = sc.nextInt();
        int tong=a+b;
        int thuong= a/b;
        int tich =a*b;
        int chiaLayDu = a%b;
        System.out.println("Tổng:"+ tong);
        System.out.println("Thương:"+ thuong);

        System.out.println("Tích:"+tich );

        System.out.println("Chia lấy dư:"+ chiaLayDu);

    }
}
