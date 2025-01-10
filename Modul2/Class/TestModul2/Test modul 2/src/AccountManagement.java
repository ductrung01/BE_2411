import java.util.ArrayList;
import java.util.Scanner;

public class AccountManagement {

    ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Employee> employees = null;

    public ArrayList<Account> getAccounts() {
        return accounts;
    }


    public AccountManagement(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void chonChucNangQuanLyTaiKhoan() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("---------Quản lý tài khoản---------");
            System.out.println("1.Thêm tài khoản mới.");
            System.out.println("2.Sửa thông tin tài khoản.");
            System.out.println("3.Xóa tài khoản.");
            System.out.println("4.Tìm kiếm tài khoản.");
            System.out.println("5.Hiển thị tất cả tài khoản.");
            System.out.println("6.Thoát chương trình");
            System.out.println("------------------------------------");
            System.out.println("Chọn chức năng quản lý tài khoản: ");

            try {
              n=  sc.nextInt();
                switch (n) {
                    case 1:
                        addAccount();
                        break;
                    case 2:
                        updateAccount();
                        break;
                    case 3:
                        deleteAccount();
                        break;
                    case 4:
                        searchAccount();
                        break;
                    case 5:
                        showAllAccount();
                        break;
                    case 6:
                        System.out.println("Dừng nhập!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                sc.next();
            }
        }   while (n != 6) ;
    }
    public boolean isManagerExist(String managerAccountNumber) {
        for (Employee e : employees) {
            if (e.getId().equals(managerAccountNumber)) {
                return true;
            }
        }
        return false;
    }
    public boolean  isAccountCodeExist(String accountNumber){
        for(Account a: accounts){
            if(a.getAccountNumber().equals(accountNumber )){
                return true;
            }
        }
        return false;
    }
    public boolean isAccountHolderExist(String accountHolder){
        for(Account a: accounts){
            if(a.getAccountHolder().equals(accountHolder)){
                return true;
            }
        }
        return false;
    }
    public void addAccount() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do{
            System.out.println("---------Menu Thêm Tài Khoản Mới---------");
            System.out.println("1.Tiếp tục");
            System.out.println("2.Thoát.");
            System.out.println("Vui lòng nhập lựa chọn: ");
            try{
                n =  sc.nextInt();
                sc.nextLine();
                switch (n) {
                    case 1:
                        System.out.println("Nhập thông tin tài khoản:");
                        System.out.println("Số tài khoản: ");
                        String accountNumber = sc.nextLine();
                        System.out.println("Chủ tài khoản: ");
                        String accountHolder = sc.nextLine();
                        System.out.println("Số dư ban đầu: ");
                        double balance = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Nhân viên quản lí(Nhập mã nhân viên):");
                        String managerAccountNumber = sc.nextLine();
                        if(isAccountCodeExist(accountNumber) == true ) {
                            System.out.println("Thêm không thành công!Số tài khoản " + accountNumber + " đã tồn tại trong hệ thống.");
                            System.out.println("Vui lòng chọn Số tài khoản khác.");
                        } else if (!isManagerExist(managerAccountNumber)) {
                            System.out.println("Mã nhân viên không tồn tại trong hệ thống. Vui lòng kiểm tra lại.");

                        }else{
                           accounts.add(new Account(accountNumber,accountHolder,balance,null));
                            System.out.println("Thêm tài khoản thành công!");
                        }
                        break;
                    case 2:
                        System.out.println("Dừng nhập!");
                        break;
                    default:
                        System.out.println("Nhập giá trị không hợp lệ! Vui lòng nhập lại");
                }
            }catch (Exception e){

            }
        }while (n != 2);

    }
    public void updateAccount() {
        Scanner sc = new Scanner(System.in);

        int n = 0;
        do{
            System.out.println("---------Sửa Thông Tin Tài Khoản---------");
            System.out.println("1.Tiếp tục.");
            System.out.println("2.Thoát.");
            System.out.println("Vui lòng nhập lựa chọn: ");
            try{
                n =  sc.nextInt();
                sc.nextLine();
                switch (n){
                    case 1:
                        System.out.println("Nhập số tài khoản cần sửa:");
                        String accountNumber = sc.nextLine();
                        if (isAccountCodeExist(accountNumber)) {
                            for (int i = 0; i < accounts.size(); i++) {
                                if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                                    System.out.println("Nhập tên chủ tài khoản mới: ");
                                    String newAccountHolder = sc.nextLine();
                                    System.out.println("Nhập số dư tài khoản mới: ");
                                    double newBalance = sc.nextDouble();
                                    accounts.get(i).setAccountHolder(newAccountHolder);
                                    accounts.get(i).setBalance(newBalance);
                                    System.out.println("Tài khoản đã cập nhật thành công");
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Số tài khoản " + accountNumber + " không hợp lệ! Vui lòng thử lại");
                        }
                        break;
                    case 2:
                        System.out.println("Dừng nhập!");
                        break;
                    default:
                        System.out.println("Giá trị nhập không hợp lệ! Vui lòng nhập lại");
                }
            }catch (Exception e){
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                sc.next();
            }
        }while (n != 2 );


    }
//    public boolean foundAccountNumber(String accountNumber){
//        for(Account a: accounts){
//            if(a.getAccountNumber().equals(accountNumber)){
//                return true;
//            }
//        }
//        return false;
//    }
public void showAllAccount(){
    for (int i = 0; i < accounts.size(); i++) {
        if (accounts.get(i) == null){
            continue;
        }
        System.out.println("------------- Tài khoản: " + i);
        accounts.get(i).showInfo();
    }
}
    public void deleteAccount() {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        do {
            System.out.println("---------Xóa tài khoản---------");
            System.out.println("1. Tiếp tục.");
            System.out.println("2. Thoát.");
            System.out.println("Vui lòng nhập lựa chọn: ");
            try {
                n = sc.nextInt();
                sc.nextLine();
                switch (n) {
                    case 1:
                        System.out.println("Nhập tài khoản muốn xóa:");
                        String removeAccountNumber = sc.nextLine();
                        Account accountToRemove = findAccount(removeAccountNumber);
                        if (accountToRemove != null) {
                            double balance = accountToRemove.getBalance();
                            if (balance > 0) {
                                System.out.println("Tài khoản vẫn còn số dư: " + balance + ". Vui lòng rút hết trước khi xóa.");
                                System.out.println("Nhập số tiền cần rút:");
                                double amount = sc.nextDouble();
                                if (amount <= balance) {
                                    accountToRemove.withdraw(amount);
                                    System.out.println("Đã rút: " + amount);
                                } else {
                                    System.out.println("Số tiền rút không hợp lệ. Vui lòng thử lại.");
                                    break;
                                }
                            }
                            accounts.remove(accountToRemove);
                            System.out.println("Tài khoản " + removeAccountNumber + " đã được xóa thành công.");
                        } else {
                            System.out.println("Số tài khoản " + removeAccountNumber + " không tồn tại trong hệ thống. Vui lòng thử lại!");
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

    public void searchAccount() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do{
            System.out.println("1.Tiếp tục.");
            System.out.println("2.Thoát.");
            System.out.println("Vui lòng nhập lựa chọn: ");
            try{
                n = sc.nextInt();
                sc.nextLine();
                switch (n){
                    case 1:
                        System.out.println("Nhập vào chủ tài khoản hoặc số tài khoản: ");
                        String searchAccountNumberOrHolder = sc.nextLine();
                        boolean found = false;

                            for(int i = 0; i < accounts.size(); i++){
                                if(accounts.get(i).getAccountNumber().equals(searchAccountNumberOrHolder) || accounts.get(i).getAccountHolder().equals(searchAccountNumberOrHolder)){

                                    accounts.get(i).showInfo();
                                    found = true;
                                }

                        }if(!found ){
                            System.out.println("Không tìm thấy "+searchAccountNumberOrHolder+ "trong hệ thống. Vui lòng nhập chính xác!!!");
                            break;
                        }
                    case 2:
                }
            }catch(Exception e){
                System.out.println("Đã xảy ra lỗi: "+e.getMessage());
                sc.next();
            }
        }while (n!=2);
    }
    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
