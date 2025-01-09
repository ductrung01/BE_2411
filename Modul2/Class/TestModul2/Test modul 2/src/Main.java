import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement();
        AccountManagement am = new AccountManagement();
        TransactionManagement tm = new TransactionManagement();
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do{
            System.out.println("----------Menu----------");
            System.out.println("1.Quản lý tài khoản.");
            System.out.println("2.Giao dịch tài khoản.");
            System.out.println("3.Quản lý giao dịch.");
            System.out.println("4.Quản lý nhân viên.");
            System.out.println("5.Thoát Chương Trình !!!");
            System.out.println("-------------------------");
            System.out.println("Nhập lựa chọn của bạn:");
            try{
                n = sc.nextInt();
                switch (n){
                    case 1:
                        am.chonChucNangQuanLyTaiKhoan();
                        break;
                    case 2:
                        tm.chonChucNangGiaoDichTaiKhoan();
                        break;
                    case 3:
                        break;
                    case 4:
                        em.chonChucNangQuanLyNhanVien();
                        break;
                    case 5:
                        System.out.println("Thoát chương trình!");
                        break;

                }
            }catch(Exception e){
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                sc.next();//Tiêu Thụ Giá Trị Không Hợp Lệ, đọc và làm sạch bộ nhớ đệm Scanner
                // nếu không có dòng sc.next(), giá trị nhập vào sẽ vẫn nằm ở bộ nhớ đệm đầu vào đúng ko
            }


        }while (n != 5);
    }
}