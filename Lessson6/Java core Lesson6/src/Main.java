import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Elephant elephant = new Elephant() ;
        Lion lion = new Lion() ;
        Monkey monkey = new Monkey() ;
        Animal [] animals = {elephant,lion,monkey};
        for(Animal a : animals){
            a.makeSound();
        }

        };

    }
