import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        // Vòng lặp
        Scanner sc = new Scanner(System.in);
        int n ;
        double sum = 0;
        do{
            System.out.println("Nhập vào n: ");
            n = sc.nextInt();
        }while (n<0);
        for (int i = 0; i < n; i++){
            sum = sum + (i*i*i);

        }
        System.out.println("TỔng chuỗi là:"+ sum);
    }
}
