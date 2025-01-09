import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private Account account;
    private Employee employee;
    private String type;
    private double amount;
    private LocalDateTime timeStamp;

    public Transaction(String id, Account account, Employee employee, String type, double amount) {
        this.id = id;
        this.account = account;
        this.employee = employee;
        this.type = type;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    @Override
    public String toString() {
        return "Transaction id: " + id +
                ",Tài khoản: " + account.getAccountNumber() +
                ",Nhân viên: " + employee.getName()+
                ",Loại giao dịch: "+ type+
                ",Số tiền giao dịch: "+ amount+
                ",Thời gian: " + timeStamp;
    }

}
