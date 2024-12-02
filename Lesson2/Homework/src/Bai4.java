import java.util.Scanner;

public class Bai4 {
    public static void tinhDiemSinhVien() {
        Scanner sc = new Scanner(System.in);
        double diemChuyenCan, diemGiuaKi, diemCuoiKi;
        int heSo = 3;

        System.out.println("Nhập điểm chuyên cần của sinh viên:");
        diemChuyenCan = sc.nextDouble();
        System.out.println("Nhập điểm giữa kì của sinh viên:");
        diemGiuaKi = sc.nextDouble();
        System.out.println("Nhập điêm cuối kì của sinh viên:");
        diemCuoiKi = sc.nextDouble();
        double diemTrungBinh = (diemChuyenCan + diemGiuaKi + diemCuoiKi) / heSo;
        if (diemTrungBinh >= 9) {
            System.out.println("Sinh viên xếp loại A");
        } else if (diemTrungBinh >= 7 && diemTrungBinh < 9) {
            System.out.println("Sinh viên xếp loại B");
        } else if (diemTrungBinh >= 5 && diemTrungBinh < 7) {
            System.out.println("Sinh viên xếp loại C");
        } else if (diemTrungBinh < 5) {
            System.out.println("Sinh viên xếp loại D");
        }
    }

    public static void kiemTraLoaiTamGiac() {
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
            } else {
                System.out.println("Đây ko phải tam giác");
            }
        }
    }

    public static void tinhTienDien() {
        Scanner sc = new Scanner(System.in);
        double soDienSuDung;
        double bac1 = 1.678;
        double bac2 = 1.734;
        double bac3 = 2.014;
        double bac4 = 2.536;
        double bac5 = 2.834;
        double bac6 = 2.927;

        double tienDien = 0;
        System.out.println("Nhập vào số điện sử dụng: ");
        soDienSuDung = sc.nextDouble();
        if (soDienSuDung >= 0 && soDienSuDung <= 50) {
            tienDien = soDienSuDung * bac1;

        } else if (soDienSuDung >= 51 && soDienSuDung <= 100) {
            tienDien = (bac1 * 50) + ((soDienSuDung - 50) * bac2);

        } else if (soDienSuDung >= 101 && soDienSuDung <= 200) {
            tienDien = (bac1 * 50) + (50 * bac2) + (soDienSuDung - 100) * bac3;

        } else if (soDienSuDung >= 201 && soDienSuDung <= 300) {
            tienDien = (bac1 * 50) + (bac2 * 50) + (soDienSuDung - 200) * bac4;

        } else if (soDienSuDung >= 301 && soDienSuDung <= 400) {
            tienDien = (50 * bac1) + (50 * bac2) + (100 * bac3) + (100 * bac4) + (soDienSuDung - 300) * bac5;

        } else {
            tienDien = (50 * bac1) + (50 * bac2) + (100 * bac3) + (100 * bac4) + (100 * bac5) + (soDienSuDung - 400) * bac6;
        }
        System.out.println("Tiền điện phải trả là : " + tienDien + " VNĐ");

    }
public static void menu(){
    Scanner scanner = new Scanner(System.in);
    int choice = 0;

    while (choice != 4) {
        // Hiển thị menu
        System.out.println("1. Tính điểm sinh viên");
        System.out.println("2. Kiểm tra loại tam giác");
        System.out.println("3. Tính tiền điện");
        System.out.println("4. Kết thúc");
        System.out.print("Chọn chức năng: ");


        choice = scanner.nextInt();


        switch (choice) {
            case 1:
                tinhDiemSinhVien();
                break;
            case 2:
                kiemTraLoaiTamGiac();
                break;
            case 3:
                tinhTienDien();
                break;
            case 4:
                System.out.println("Kết thúc chương trình.");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại.");
        }
    }

}
    public static void main(String[] args) {
        menu();
//        Bài 4
//        Viết chương trình tổ chức 1 menu gồm 3 chức năng để gọi 3 bài trên và một chức
//        năng để thoát khỏi ứng dụng.
//        HƯỚNG DẪN
//	Tạo phương thức menu() xuất ra màn hình thực đơn như sau
//        + 	+
//                1.	Tính điểm sinh viên
//        2.	Kiểm tra loại tam giác
//        3.	Tính tiền điện
//        4.	Kết thúc
//        + 	+ Chọn chức năng: _
//	Viết mã vào phương thức menu để nhận vào 1 số từ 1 đến 4.
//	Sử dụng lệnh switch để gọi đến các hàm chức năng tương ứng.
//                o	tinhDiemSinhVien()
//        Chứa mã của bài 1
//        o	kiemTraLoaiTamGiac()

//        Chứa mã của bài 2
//        o	tinhTienDien()
//        Chứa mã của bài 3

    }
}
