package onClass;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a , b , c;

        System.out.println("Nhập a:");
        a = sc.nextInt();
        System.out.println("Nhập b:");
        b = sc.nextInt();
        System.out.println("Nhập c:");
        c = sc.nextInt();
        float denta = b*b - (4 * a * c);
        if(denta < 0){
            System.out.println("Phương trình vô nghiệm");
        }else if(denta == 0){
            double x = -b /(2*a);
            System.out.println("Phương trình có cặp nghiệm kép :"+x);
        }else{
            double x1 = (-b + Math.sqrt(denta))/(2*a);
            double x2 = (-b - Math.sqrt(denta))/(2*a);
            System.out.println("Phương trình có hai nghiệm phân biệt:");
            System.out.println("x1 = "+x1);
            System.out.println("x2 = "+x2);
        }
    }
}
