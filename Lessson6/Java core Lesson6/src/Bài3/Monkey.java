package Bài3;

public class Monkey extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Monkey is chattering");
    }
    @Override
    public void action() {
        System.out.println("Monkey is climbing trees");
    }
}
