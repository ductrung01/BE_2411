package Bài3;

public class Lion extends Animal {
//     2. Tạo các lớp con:    • Lion: có phương thức riêng roar() (in ra “Lion is roaring”).    •

    public void roar() {
        System.out.println("Lion is roaring");
    }

    @Override
    public void makeSound() {
        System.out.println("Lion is roading");
    }

    //    3. Tạo đối tượng Lion và Elephant, gọi các phương thức chung (eat())
//    và phương thức riêng (roar(), trumpet()) của chúng.
    @Override
    public void action() {
        System.out.println("Lion is hunting");
    }
}
