package Bài3;

public abstract class Animal {
  /*  Bài tập 3: Áp dụng tính kế thừa, trừu tượng, và đa hình Đề bài:
    Phát triển chương trình quản lý động vật trong sở thú từ bài tập 2:
            1. Thêm một phương thức action() trong lớp trừu tượng Animal.
            • Phương thức này sẽ được ghi đè ở từng lớp con để mô tả hành động đặc trưng của mỗi loại động vật:
            • Lion: in ra “The lion is hunting.”
            • Elephant: in ra “The elephant is spraying water.”
            • Monkey: in ra “The monkey is climbing trees.”
            2. Thêm phương thức showInfo() để hiện thị thông tin chi tiết của mỗi con vật gồm tên, tuổi
 3. Tạo class ManagerAnimal cho phép thực hiện các yêu cầu:
    a) có 1 danh sách các động vậy Lion,Elephant,Monkey, cho phép người dùng nhập vào n, chính là
    tổng số lượng các động vật mà sở thú quản lý
    b) nhập vào danh sách các động vật củ sở thú và cho phép người dùng lựa chọn
        1) nhập vào Lion
        2) nhập vào Elephant
        3) nhập vào Monkey
        4) Dừng nhập vào
    chú ý: nhập vào là bao gồm cả các thông tin tên, tuổi
    c) Hiển thị danh sách tất cả các động vật trong sở thú
    d) Thêm 1 con vật nếu danh sách đầy, phải mở rộng danh sách, mặc định mở rộng 10 phần tử
    e) Cho phép nhập tên con vật, hiển thị thông tin con vật nếu có, không phân biệt hoa thường
    f) Cho phép xóa con vật theo tên

 */
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("Animal is eating");
    }
    public abstract void makeSound();
    public abstract void action();
    public void showInfo(){
        System.out.println("Animal name: " + name);
        System.out.println("Animal age: " + age);
    }
}