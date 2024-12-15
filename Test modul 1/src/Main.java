import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
       Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chức năng: ");
        int type = 0 ;
        System.out.println("-----Menu Quản Lý Danh Sách Sinh Viên-----");

        do {
            System.out.println("1. Thêm sinh viên vào danh sách.");
            System.out.println("2. Sửa thông tin sinh viên.");
            System.out.println("3. Xóa sinh viên khỏi danh sách.");
            System.out.println("4. Tìm kiếm sinh viên theo tên.");
            System.out.println("5. Hiển thị danh sách sinh viên.");
            System.out.println("6. Thoát!");
            type = sc.nextInt();
            switch (type) {
                case 1:
                sm.addStudent();
                break;
                case 2:
                 sm.updateStudentByStudentCode();
                 break;
                case 3:
                    sm.deleteStudentByStudentCode();
                break;
                case 4:
                    sm.searchStudentByName();
                break;
                case 5:
                sm.showAllStudent();
                break;
                case 6:
                break;
                default:
                    System.out.println("Nhập sai định dạng, đề nghị nhập lại");

            }
        }
        while(type != 6);
    }
}