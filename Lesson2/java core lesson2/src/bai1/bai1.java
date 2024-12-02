package bai1;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
//        Nhập từ bàn phím số nguyên viết chương trình kiểm tra số chẵn, lẻ
            Scanner sc = new Scanner(System.in);
            int a;
            System.out.println("Nhập số a : ");
            a = sc.nextInt();
            if(a%2==0){
                System.out.println(a + " là số chẵn");
            }
            else{
                System.out.println(a + " là số lẻ");
            }
    }
}
