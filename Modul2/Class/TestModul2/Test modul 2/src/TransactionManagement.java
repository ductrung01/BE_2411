import java.util.ArrayList;
import java.util.Scanner;

public class TransactionManagement {
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    AccountManagement am = new AccountManagement();
    Scanner sc = new Scanner(System.in);
    ArrayList<Account> accounts = am.getAccounts();

    public void chonChucNangGiaoDichTaiKhoan(){
        int n = 0;
        do{
            System.out.println("---------Giao dịch tài khoản---------");
            System.out.println("1.Nạp tiền.");
            System.out.println("2.Rút tiền.");
            System.out.println("3.Chuyển khoản.");
            System.out.println("4.Thoát.");
            System.out.println("Chọn chức năng giao dịch tài khoản:");
            try{
                n =sc.nextInt();
             switch (n){
                 case 1:
                     depositMoney();
                     break;
                 case 2:
                     withdrawMoney();
                     break;
                 case 3:
                 case 4:
                     System.out.println("Dừng nhập!");
                     break;
             }
            }catch(Exception e){
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                sc.next();
            }
        }while (n != 4);
    }
    public void depositMoney() {
        int n = 0;
        do {
            System.out.println("1. Nạp tiền vào tài khoản.");
            System.out.println("2. Thoát!");
            System.out.println("Vui lòng nhập lựa chọn:");
            try {
                n = sc.nextInt();
                sc.nextLine();
                switch (n) {
                    case 1:
                        System.out.println("Nhập số tài khoản của khách hàng:");
                        String accountNumber = sc.nextLine().trim();
                        boolean accountFound = false;

                        for (int i = 0; i < accounts.size(); i++) {
                            if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                                accountFound = true;
                                System.out.println("Nhập số tiền cần nạp: ");
                                double amount = sc.nextDouble();
                                if (amount <= 0) {
                                    System.out.println("Số tiền nạp phải lớn hơn 0. Vui lòng thử lại!.");
                                    return;
                                }
                                accounts.get(i).deposit(amount);
                                System.out.println("Nạp tiền thành công! Số tiền đã nạp: " + amount);
                                break;
                            }
                        }

                        if (!accountFound) {
                            System.out.println("Tài khoản " + accountNumber + " không tồn tại trong hệ thống. Vui lòng thử lại!");
                        }
                        break;
                    case 2:
                        System.out.println("Thoát thành công!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                sc.next();
            }
        } while (n != 2);
    }

    public void withdrawMoney(){
        int n = 0;
        do {
            System.out.println("1. Rút tiền ra khỏi tài khoản.");
            System.out.println("2. Thoát!");
            System.out.println("Vui lòng nhập lựa chọn:");
            try {
                n = sc.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("Nhập số tài khoản của khách hàng:");
                        sc.nextLine();
                        String accountNumber = sc.nextLine();
                        boolean accountFound = false;

                        for (Account account : accounts) {
                            if (account.getAccountNumber().equals(accountNumber)) {
                                accountFound = true;
                                System.out.println("Nhập số tiền cần rút: ");
                                double amount = sc.nextDouble();
                                if (amount <= 0) {
                                    System.out.println("Số tiền rút phải lớn hơn 0. Vui lòng thử lại!.");
                                    return;
                                }
                                account.withdraw(amount);
                                System.out.println("Rút tiền thành công! Số tiền đã rút: " + amount);
                                break;
                            }
                        }

                        if (!accountFound) {
                            System.out.println("Tài khoản " + accountNumber + " không tồn tại trong hệ thống. Vui lòng thử lại!");
                        }
                        break;
                    case 2:
                        System.out.println("Thoát thành công!");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                sc.next();
            }
        } while (n != 2);
}
}
