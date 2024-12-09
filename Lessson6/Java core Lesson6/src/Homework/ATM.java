package Homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Acount[] accounts = new Acount[10];
        int id;
        double lai = 4.5 / 100;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse("09/12/2024");
        boolean tiepTuc = true;
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Acount(i, 100, lai, date);

        }
        while (tiepTuc) {
            System.out.print("Nhập ID (từ 0 đến 9): ");
            id = sc.nextInt();
            sc.nextLine();
            if (id >= 0 && id <= 9) {
                boolean quayLaiMenu = false;
                while (quayLaiMenu == false) {
                    System.out.println("===== MENU CHÍNH =====");
                    System.out.println("1: Xem số dư");
                    System.out.println("2: Rút tiền");
                    System.out.println("3: Gửi tiền");
                    System.out.println("4: Thoát Lựa chọn của bạn");
                    System.out.println("Nhập vào lựa chọn của bạn :");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("Số dư tài khoản: " + accounts[id].balance);
                            break;
                        case 2:
                            System.out.println("Nhập vào số tiền cần rút: ");
                            int rutTien = sc.nextInt();
                            sc.nextLine();
                            accounts[id].withdraw(rutTien);
                            break;
                        case 3:
                            System.out.println("Nhập vào số tiền cần nạp: ");
                            int napTien = sc.nextInt();
                            sc.nextLine();
                            accounts[id].deposit(napTien);
                            break;
                        case 4:
                            quayLaiMenu = true;
                            break;
                        default:
                            System.out.println("Lựa chọn khong hop le ");
                            break;

                    }

                }
            } else {

                System.out.println("ID không hợp lệ. Vui lòng nhập lại!");
            }


        }

    }
}