package Lesson1;

import java.util.Scanner;

//
public class HelloWorld
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Hello World");



    System.out.println("Nhập họ và tên:");

    String fullName = new Scanner(System.in).nextLine();
    System.out.println("Nhập ngày tháng năm sinh:");
     String date = new Scanner(System.in).nextLine();
    System.out.println("Nhập Quê quán:");
     String country = new Scanner(System.in).nextLine();
    System.out.println("Nhập trường học:");
    String school = new Scanner(System.in).nextLine();

    System.out.print("Xin chào" +fullName + "đến từ" + country+", sinh ngày"+date+"học tại trường"+school);
    }
}
