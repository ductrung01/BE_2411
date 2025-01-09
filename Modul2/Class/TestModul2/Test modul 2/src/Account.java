import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private Employee employeeInCharge;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, String accountHolder, double balance, Employee employeeInCharge) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.employeeInCharge = employeeInCharge;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Employee getEmployeeInCharge() {
        return employeeInCharge;
    }

    public void setEmployeeInCharge(Employee employeeInCharge) {
        this.employeeInCharge = employeeInCharge;
    }

    public List<Transaction> getTransactions() {
        return transactionHistory;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactionHistory = transactions;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Đã nạp: " + amount);
            System.out.println("Số dư tài khoản: " + balance);
            Transaction transaction = new Transaction(
                    generateTransactionId(),
                    this,
                    employeeInCharge,
                    "Deposit",
                    amount
            );
            transactionHistory.add(transaction);
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    public class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }

    public void withdraw(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Số tiền nhập không hợp lệ.");
            }
            if (amount > balance) {
                throw new InsufficientFundsException("Số dư không đủ để thực hiện giao dịch.");
            }
            balance -= amount;
            System.out.println("Đã rút: " + amount);
            System.out.println("Số dư tài khoản: " + balance);
            Transaction transaction = new Transaction(
                    generateTransactionId(),
                    this,
                    employeeInCharge,
                    "Withdraw",
                    amount
            );
            transactionHistory.add(transaction);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showInfo() {
        System.out.println("Số tài khoản: " + this.accountNumber);
        System.out.println("Chủ tài khoản: " + this.accountHolder);
        System.out.println("Số dư: " + this.balance);
    }


    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }


    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }
}
