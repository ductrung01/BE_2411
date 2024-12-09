package Bài3;

import java.util.Scanner;

public class ManagerAnimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhập số lượng động vật đang quản lý");
        n = sc.nextInt();
        Lion lion = new Lion();
        Elephant elephant = new Elephant();
        Monkey monkey = new Monkey();
        Animal[] animals = {lion,elephant,monkey};

//        3. Tạo class ManagerAnimal cho phép thực hiện các yêu cầu:
//        a) có 1 danh sách các động vậy Lion,Elephant,Monkey, cho phép người dùng nhập vào n, chính là
//        tổng số lượng các động vật mà sở thú quản lý
//        b) nhập vào danh sách các động vật củ sở thú và cho phép người dùng lựa chọn
//        1) nhập vào Lion
//        2) nhập vào Elephant
//        3) nhập vào Monkey
//        4) Dừng nhập vào
//        chú ý: nhập vào là bao gồm cả các thông tin tên, tuổi
//        c) Hiển thị danh sách tất cả các động vật trong sở thú
//        d) Thêm 1 con vật nếu danh sách đầy, phải mở rộng danh sách, mặc định mở rộng 10 phần tử
//        e) Cho phép nhập tên con vật, hiển thị thông tin con vật nếu có, không phân biệt hoa thường
//        f) Cho phép xóa con vật theo tên

    }
}
