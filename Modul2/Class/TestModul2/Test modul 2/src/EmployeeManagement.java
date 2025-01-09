import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {


    //    4. Quản lý nhân viên:
//  4.1. Thêm nhân viên mới.
// 	4.2. Xem danh sách nhân viên.
// 	4.3. Gán tài khoản cho nhân viên
    ArrayList<Employee> employees = new ArrayList<>();
    public ArrayList<Employee> getEmployeess() {
        return employees;
    }
//    private int totalEmployee;
//    private int currentEmployee = 0;
//    private final int DEFAULT_NEW_SIZE = 10;
    public boolean  isemployeeCodeExist(String id){
        for(Employee e: employees){
            if(e.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    public void chonChucNangQuanLyNhanVien() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("---------Quản lý nhân viên---------");
            System.out.println("1.Thêm nhân viên mới.");
            System.out.println("2.Xem danh sách nhân viên.");
            System.out.println("3.Gán tài khoản cho nhân viên.");
            System.out.println("4.Thoát!");
            System.out.println("------------------------------------");
            System.out.println("Chọn chức năng: ");
            try {

                n = sc.nextInt();
                switch (n) {
                    case 1:
                        addEmployee();
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                sc.next();
            }
        } while (n != 4);
    }
    public void viewEmployees() {
        if(employees.isEmpty()){
            System.out.println("Không có nhân viên nào trong hệ thống!!!");
        }else{
            System.out.println("---------Danh sách nhân viên---------");
            for(Employee e: employees){
                System.out.println("ID: " + e.getId() + "\tTên nhân viên: " + e.getName() + "\tLương cơ bản: " + e.getSalary());
            }
        }
    }
    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("---------Menu Thêm Nhân Viên---------");
            System.out.println("1.Nhập thông tin nhân viên");
            System.out.println("2.Dừng nhập.");
            try {
                n = sc.nextInt();
                switch (n) {
                    case 1:
                        System.out.println("Nhập thông tin nhân viên:");
                        System.out.print("ID nhân viên: ");
                        String id = sc.next();
                        System.out.print("Tên nhân viên: ");
                        String name = sc.next();
                        System.out.print("Lương cơ bản: ");
                        double salary = sc.nextDouble();
                        if(isemployeeCodeExist(id)== true){
                            System.out.println("Mã nhân viên "+id+" đã tồn tại. Không thể thêm nhân viên!");
                        }else{
                            employees.add(new Employee(id, name, salary));
                            System.out.println("Nhân viên đã được thêm!");
                        }

                        break;

                    case 2:
                        System.out.println("Dừng nhập");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } catch (Exception e) {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                sc.next();
            }

        } while (n != 2);

    }



}