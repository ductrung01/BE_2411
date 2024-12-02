package onClass;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double luongNhanVien, timeWork;
        System.out.println("Nhập số giờ làm việc của nhân viên : ");
        timeWork = sc.nextDouble();
        if (timeWork > 40) {
            luongNhanVien = timeWork * 50000 * 1.5;
            System.out.println("Lương của nhân viên là :" + luongNhanVien);
        } else {
            luongNhanVien = timeWork * 50000;
            System.out.println("Lương nhân viên " + luongNhanVien);
        }
    }
}
