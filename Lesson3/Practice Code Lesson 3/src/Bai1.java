import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
//        Bai 1:
//        Tính S(n) = 1^3 + 2^3 + 3^3 + … + n^3  n nhập từ bàn phím
//        Nhập n từ bàn phím (n dương, bắt nhập lại nếu n âm)
//        và in ra màn hình dãy S(n)
        Scanner sc = new Scanner(System.in);
        double sum = 0 ;
        int n;
        do{
            System.out.print("Nhập n: ");
            n = sc.nextInt();
        }while (n <= 0);
        for (int i = 0; i <= n;i++){
            sum = sum + Math.pow(i,3);
        }
        System.out.println("Tổng chuối S(n) là: " + sum);

    }
}
