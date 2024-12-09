package Bài3;

public class Elephant extends Animal {
    //    Elephant: có phương thức riêng trumpet() (in ra “Elephant is trumpeting”).
    public void trumpet(){
        System.out.println("Elephant is Trumpeting");
    }

    @Override
    public void makeSound() {
        System.out.println("Elepant is trumpeting");
    }

    @Override
    public void action() {
        System.out.println("Elepant is spraying water");
    }
}
