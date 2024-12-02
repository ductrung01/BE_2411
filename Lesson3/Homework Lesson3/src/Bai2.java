import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
//        bài 2)
//        Đổi sang số nhị phân của 1 số nguyên dương n
//        Ví dụ nhập sao số dương 8 in ra màn hình số nhị phân của nó là 1000
//        7 -> 111
//        9 -> 1001
//        16 -> 10000
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao chuyen doi : ");
        int n = new Scanner(System.in).nextInt();
        int bienTam = 0;
        String ketQua ="";
        while(n!=0){
        bienTam = n%2;
        ketQua=bienTam+ketQua;
        n = n/2;
        }
        System.out.println("Ket qua chuyen nhi phan la:"+ketQua);
    }
}
