import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
//        bài 3) nhập vào n, tính giai thừa của n
//        n! = n * (n-1) * (n-2) * ... * 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = sc.nextInt();
        int giaiThua = 1;
        for (int i = n; i >0 ; i--) {
            giaiThua = giaiThua * i;

        }
        System.out.println("Giai thừa của "+n + "là: "+ giaiThua);
    }
}
