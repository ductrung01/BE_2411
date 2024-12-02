import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
//        bai 2) Viết lại chữ số đảo ngược
//        Ví dụ nhập vào số 1357 thì in ra số đảo ngược là 7531
//        (Không sử dụng nhập vào chuỗi số là String)
    Scanner sc = new Scanner(System.in);
    System.out.println("Nhập n: ");
       int n = sc.nextInt();
        int soDuoi ;
        int soDaoNguoc = 0;
        while (n != 0){
        soDuoi = n %10;
        soDaoNguoc = soDaoNguoc*10 + soDuoi;
        n = n / 10;
        }
      System.out.println("Số đảo ngược là: "+ soDaoNguoc);
    }


}
//123
//321
//
//123 % 10 = 3
//123 / 10 = 12
//
//12 % 2 = 2
//12 / 10 = 1
//
//1 % 10 = 1
//1 / 10 = 0
//
//3 * 10 * 10 + 2 * 10 + 1
// */