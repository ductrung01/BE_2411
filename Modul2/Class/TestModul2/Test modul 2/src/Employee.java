import java.util.List;
import java.util.Scanner;

public class Employee {
    private String id;
    private String name;
    private double salary;
    private List<Account> managedAccount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Account> getManagedAccount() {
        return managedAccount;
    }

    public void setManagedAccount(List<Account> managedAccount) {
        this.managedAccount = managedAccount;
    }

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.managedAccount = managedAccount;
    }
    public void  calculateBonus(){

    };
    public void addAccount(Account account) {
        managedAccount.add(account);
    }
    public void processTransaction(Transaction transaction){

    }
    public void enterInfoEmployee(){
        System.out.println("Nhập id nhân viên: ");
        this.id = new Scanner(System.in).nextLine();
        System.out.println("Tên nhân viên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Lương cơ bản: ");
        this.salary = new Scanner(System.in).nextDouble();
    }
}
