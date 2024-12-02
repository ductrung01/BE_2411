import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
//        Nhập vào chương trình 3 số nguyên dương a,b,c
//        In ra màn hình kết luận về tam giác có 3 cạnh trên (tam giác thường,
// tam giác vuông, tam giác cân, tam giác vuông cân, tam giác đều hoặc không phải tam giác)
        Scanner sc = new Scanner(System.in);
        int a, b, c;

        System.out.println("Nhập a: ");
        a = sc.nextInt();
        System.out.println("Nhập b: ");
        b = sc.nextInt();
        System.out.println("Nhâp c: ");
        c = sc.nextInt();
        int Pythagoras = ((a * a) + (b * b));
        if ((a + b) > c && (a + c) > b && (b + c) > a) {

            if (Pythagoras == (c * c)) {
                System.out.println("Tam  giác  này là tam giác vuông");
            } else if (a == b || b == c || c == a) {
                System.out.println(" Tam  nác này là tam giác cân");
            } else if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                System.out.println(" Tam giác này là tam giác vuông cân:");

            } else if (a == b && b == c && a == c) {
                System.out.println("Tam giác này là tan giác đều");
            }else {
                System.out.println("Đây ko phải tam giác");
            }
        }
    }
}
