import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int type = 0;

        System.out.println("-----Menu Quản Lý Danh Sách Sinh Viên-----");
        do {
            System.out.println("1. Thêm sinh viên vào danh sách.");
            System.out.println("2. Xóa sinh viên khỏi danh sách.");
            System.out.println("3. Hiển thị danh sách sinh viên.");
            System.out.println("4. Tìm kiếm sinh viên theo tên.");
            System.out.println("5. Sắp xếp danh sách sinh viên theo điểm thi.");
            System.out.println("6. Kiểm tra sinh viên có tồn tại không.");
            System.out.println("7. Thoát!!!");

            while (true) {
                try {
                    System.out.print("Chọn chức năng: ");
                    type = sc.nextInt();
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Lỗi: Nhập sai định dạng. Vui lòng nhập số nguyên!");
                    sc.nextLine();
                }
            }

            switch (type) {
                case 1:
                    sm.addStudent();
                    break;
                case 2:
                    sm.deleteStudentByStudentCode();
                    break;
                case 3:
                    sm.showAllStudent();
                    break;
                case 4:
                    sm.searchStudentByName();
                    break;
                case 5:
                    System.out.println("Chưa triển khai");
                    break;
                case 6:
                    System.out.println("Chưa triển khai.");
                    break;
                case 7:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        } while (type != 7);
    }
}
