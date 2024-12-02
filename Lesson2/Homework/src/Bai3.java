import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
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

//        Viết chương trình nhập vào số điện sử dụng của tháng và tính tiền điện theo phương
// pháp lũy tiến
//	Nếu số điện sử dụng từ 0 đến 50 thì giá mỗi số điện là 1000
//	Nếu số điện sử dụng trên 50 thì giá mỗi số điện vượt hạn mức là 1200
//        Bậc 1: Cho kWh từ 0 - 50	1.678
//        Bậc 2: Cho kWh từ 51 - 100	1.734
//        Bậc 3: Cho kWh từ 101 - 200	2.014
//        Bậc 4: Cho kWh từ 201 - 300	2.536
//        Bậc 5: Cho kWh từ 301 - 400	2.834
//        Bậc 6: Cho kWh từ 401 trở lên	2.927
//
//        Ví dụ:
//        40 số: 1.678 x 40 số điện
//        60 sô: 1.678 x 50 + 10 x 1_734 số điện
//        110 số: 1.678 x 50 + 50 x 1.734 + 10 x 2.014 số điện

    }
}
