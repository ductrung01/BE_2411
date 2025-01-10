import java.util.ArrayList;
import java.util.Scanner;

public class TransactionManagement {
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    ArrayList<Account> accounts = null;
    Scanner sc = new Scanner(System.in);

    public TransactionManagement(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }


    public void chonChucNangGiaoDichTaiKhoan(AccountManagement account){
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
                     banking();
                     break;
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
            System.out.println("1. Tiếp tục.");
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
            System.out.println("1. Tiếp tục.");
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
    public void banking() {
        int n = 0;
        do {
            System.out.println("1. Tiếp tục.");
            System.out.println("2. Thoát!");
            System.out.println("Vui lòng nhập lựa chọn:");
            try {
                n = sc.nextInt();
                sc.nextLine();
                switch (n) {
                    case 1:
                        System.out.println("Nhập tài khoản gửi:");
                        String accountNumberFrom = sc.nextLine();
                        System.out.println("Nhập tài khoản nhận:");
                        String accountNumberTo = sc.nextLine();
                        boolean accountFromFound = false;
                        boolean accountToFound = false;
                        Account fromAccount = null;
                        Account toAccount = null;

                        for (Account account : accounts) {
                            if (account.getAccountNumber().equals(accountNumberFrom)) {
                                accountFromFound = true;
                                fromAccount = account;
                            }
                            if (account.getAccountNumber().equals(accountNumberTo)) {
                                accountToFound = true;
                                toAccount = account;
                            }
                        }

                        if (accountFromFound && accountToFound) {
                            System.out.println("Nhập số tiền cần chuyển: ");
                            double amount = sc.nextDouble();
                            if (amount <= 0) {
                                System.out.println("Số tiền chuyển phải lớn hơn 0. Vui lòng thử lại!");
                                return;
                            }

                            if (fromAccount.getBalance() < amount) {
                                System.out.println("Số dư không đủ để thực hiện chuyển khoản. Vui lòng thử lại!");
                            } else {
                                fromAccount.withdraw(amount);
                                toAccount.deposit(amount);
                                System.out.println("Chuyển khoản thành công! Số tiền đã chuyển: " + amount);

                            }
                        } else {
                            if (!accountFromFound) {
                                System.out.println("Tài khoản gửi " + accountNumberFrom + " không tồn tại.");
                            }
                            if (!accountToFound) {
                                System.out.println("Tài khoản nhận " + accountNumberTo + " không tồn tại.");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Dừng nhập!");
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
    public void displayAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Không có giao dịch nào trong hệ thống.");
        } else {
            System.out.println("Danh sách toàn bộ giao dịch:");
            for (Transaction t : transactions) {
                System.out.println(t.toString());
            }
        }
    }


}
