package Homework.bai2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        double lai = 4.5 / 100;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse("09/12/2024");
        Acount account = new Acount(111, 20000, lai, date);
        account.withdraw(2500);
        System.out.println("Số dư : " + account.balance);
        account.deposit(3000);
        System.out.println("Số dư : " + account.balance);
        System.out.println("Tiền lãi hàng tháng: " + account.getMonthlyInterest());
        System.out.println("Ngày tài khoản được tạo: " + account.dateCreated);

    }
}