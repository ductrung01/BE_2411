package bai1homework;

import java.time.LocalDate;

public class Account {
    private  int id ;
    private  double balance ;
    private double annualInterestRate ;
    private LocalDate dateCreated = LocalDate.now();

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance =balance;
        this.annualInterestRate =annualInterestRate;
        this.dateCreated = LocalDate.now();
    }

    public Account() {
        this.id = 0;
        this.balance =0.0;
        this.annualInterestRate =0.0;
        this.dateCreated = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
    public double getMonthlyInterestRate(){
        return annualInterestRate/12;
    }
    public double getMonthlyInterest(){
        return balance*getMonthlyInterestRate();
    }
    public void deposit(double amount){
        if(amount > balance){}
    }
}
