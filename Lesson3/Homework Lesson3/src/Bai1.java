import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
//bài 1)
//Cần có tổng 200.000đ từ 3 loại giấy bạc 1000đ, 2000đ, và 5000đ.
//Lập chương tình để tìm tất cả các phương án có thể sử dụng các
//mệnh giá trên để tạo ra tổng 200.000đ
        Scanner sc = new Scanner(System.in);
        int soLuongGiayBacLoai1 , soLuongGiayBacLoai2, soLuongGiayBacLoai5;
        int target = 200000;
        int gialoai1 = 1000;
        int gialoai2 = 2000;
        int gialoai5 = 5000;
        for(soLuongGiayBacLoai1 = 0; soLuongGiayBacLoai1 < target/gialoai1; soLuongGiayBacLoai1++){
            for(soLuongGiayBacLoai2 = 0 ; soLuongGiayBacLoai2 < target/gialoai2; soLuongGiayBacLoai2++){
               for(soLuongGiayBacLoai5 = 0;soLuongGiayBacLoai5<target/gialoai5 ;soLuongGiayBacLoai5++) {
                   System.out.println("Giấy bạc loại 1: " + soLuongGiayBacLoai1 + "," + "Giấy bạc loại 2: " + soLuongGiayBacLoai2 + "," + " Giấy bạc loại 5: " + soLuongGiayBacLoai5);

               }

            }

        }
    }
}
