package Lesson1;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        int height ,width ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều dài: ");
        height = sc.nextInt();
        System.out.println("Nhập chieuf rộng: ");
        width = sc.nextInt();

        int dienTich = height * width;
        System.out.println("Diện tích là:"+dienTich);
    }
}
