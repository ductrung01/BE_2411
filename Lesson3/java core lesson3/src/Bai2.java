//import java.util.Scanner;
//
//public class Bai2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n ;
//        int soDaoNguoc = 0;
//        int chuSo;
//        while ( n !=0){
//            chuSo = n % 10;
//            System.out.println(chuSo);
//            soDaoNguoc = soDaoNguoc * 10 + (n%10);
//        }
//        /*
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
//
//        System.out.println("Nhập n : ");
//
//    }
//}
////n = 123
////        123 % 10 = 3
////soDaoNguoc = 0 * 10 + 3 = 3
////n = 123 / 10 = 12
////
////        12 % 10 = 2
////soDaoNguoc = 3 * 10 + 2 = 32
////n = 12 / 10 = 1
////
////        1 % 10 = 1
////soDaoNguoc = 32 * 10 + 1 = 321
////n = 1 / 10 = 0
////
////n != 0 => Loop stopped