import java.util.Scanner;

public class Bai3 {
    public  static  void nhapMang(int[] mang){
        int duLieuMang ;
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<mang.length;i++){
            System.out.println("Nhập phần tử thứ:"+(i+1));
            mang[i]= sc.nextInt();
            duLieuMang= mang[i];

        }

    }
    public static void hienThi(int[]mang){
        for(int i=0;i<mang.length;i++){
            System.out.print(" "+mang[i]);
        }
    }
    public static void tinhTongChanVaLe(int[] mang){
        int tongSoChan = 0;
        int tongSoLe = 0;
        for(int i=0;i<mang.length;i++){
            if(mang[i]%2==0){
                tongSoChan += mang[i];
            }else{
                tongSoLe+=mang[i];
            }
        }
        System.out.println("Tổng các số chẵn là:"+tongSoChan);
        System.out.println("Tổng các số lẻ là:"+tongSoLe);
    }
    public static void searchSoNguyenTo(int[]mang){
        int duLieuSoNguyenSo;
        for(int i=0;i<mang.length;i++){

            if(mang[i]==2 && mang[i]%i ==0) {
                System.out.println(mang[i]);
                duLieuSoNguyenSo = mang[i];
            }
        }
        System.out.println("Các số nguyên tố trong mảng là: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhập số phần tử:");
        n = sc.nextInt();
        int[] mang = new int[n];
        nhapMang(mang);
        hienThi(mang);
        tinhTongChanVaLe(mang);
    }
}
//        Bài 3)
//        Mô tả bài toán:
//        Bạn sẽ xây dựng một chương trình Java có thể thực hiện các tác vụ phức tạp sau:
//        1.	Nhập một mảng các số nguyên.
//        2.	Tính tổng các phần tử chẵn và tổng các phần tử lẻ trong mảng.
//        3.	Tìm và in ra các số nguyên tố có trong mảng.
//        4.	Sắp xếp mảng sao cho:
//        o	Các phần tử chẵn được sắp xếp theo thứ tự giảm dần.
//                o	Các phần tử lẻ được sắp xếp theo thứ tự tăng dần.
//        5.	Chia mảng thành 2 mảng con:
//        o	Mảng 1: Chứa tất cả các phần tử có giá trị nhỏ hơn hoặc bằng trung bình của mảng.
//                o	Mảng 2: Chứa tất cả các phần tử có giá trị lớn hơn trung bình của mảng.
//        6.	Tìm số lượng phần tử trùng lặp trong mảng và in ra các phần tử trùng lặp.
//        7.	Thêm một phần tử vào mảng:
//        o	Cho phép người dùng thêm một phần tử vào mảng tại vị trí chỉ định (index).
//                o	Nếu mảng đã đầy, tự động mở rộng mảng.
//        8.	Xoá một phần tử khỏi mảng:
//        o	Cho phép người dùng nhập vào một giá trị phần tử và xoá phần tử đó trong mảng.
//                Yêu cầu:
//        1.	Nhập mảng: Bạn sẽ nhập một mảng các số nguyên từ bàn phím.
//        2.	Tìm số nguyên tố: Viết một hàm để kiểm tra xem một số có phải là số nguyên tố hay không, sau đó tìm và in ra tất cả các số nguyên tố trong mảng.
//        3.	Chia mảng thành hai mảng con:
//        o	Tính trung bình của mảng.
//        o	Duyệt qua các phần tử và chia chúng thành 2 mảng con: một mảng chứa các phần tử nhỏ hơn hoặc bằng trung bình, mảng còn lại chứa các phần tử lớn hơn trung bình.
//        4.	Thêm phần tử vào mảng: Bạn cần thêm một phần tử vào mảng tại chỉ định index. Nếu mảng đã đầy, mở rộng mảng tự động.
//        5.	Xoá phần tử khỏi mảng: Xoá một phần tử trong mảng nếu phần tử đó tồn tại.


