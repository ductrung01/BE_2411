import java.util.Scanner;
//        bai 1:
//        cho nguoi dung nhap vao n so tu nhien
//                + n do người dùng nhập
//                + sau đó cho phép người dùng nhập vào n số tự nhiên
//        yếu cầu:
//        1) Hiển thị các số người dùng nhập vào
//        2) Tính tổng các số trong mảng
//        3) Tìm số lớn nhất và nhỏ nhất trong mảng
public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhập số phần tử");
        n = sc.nextInt();
        int[] mang = new int[n];
        nhapMang(mang);
        tinhTong(mang);
        numberMax(mang);
        numberMin(mang);
    }
    public static void hienThi (int [] mang){

    for(int i = 0; i < mang.length; i++){
        System.out.printf(" "+mang[i]);
    }

    }
    public static void nhapMang(int [] mang) {
        int duLieuMang ;
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < mang.length;i++){
            System.out.println("Nhập phần tử thứ " + (i+1));
            mang[i] = sc.nextInt();
            duLieuMang= mang[i];
        }
        hienThi(mang);

    }
public static void tinhTong(int [] mang) {
        int sum = 0;
        for(int i = 0 ; i < mang.length;i++){
            sum += mang[i];
        }
      System.out.println("Tổng các phần tử trong mảng là: "+ sum);
}
public static void numberMin(int [] mang) {
        int numberMin = mang[0] ;
        for(int i = 0 ; i < mang.length;i++){
            if(numberMin > mang[i]){
                numberMin = mang[i];
            }
        }
        System.out.println("Min number: "+numberMin);
}
public static void numberMax(int [] mang) {
    int numberMax = mang[0] ;
    for(int i = 0 ; i < mang.length;i++){
        if(numberMax < mang[i]){
            numberMax = mang[i];
        }
    }
    System.out.println("Max number: "+numberMax);
}

}
