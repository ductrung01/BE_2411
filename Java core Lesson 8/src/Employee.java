public abstract class Employee {
    private int codeEmployee;
    private String fullName;
    private int phoneNumber;
    private int dayWork;

    public void setCodeEmployee(int codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDayWork(int dayWork) {
        this.dayWork = dayWork;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public int getCodeEmployee() {
        return codeEmployee;
    }

    public String getFullName() {
        return fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getDayWork() {
        return dayWork;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    private double hourlySalary;
    public Employee(int codeEmployee, String fullName, int phoneNumber, int dayWork, double hourlySalary) {
        this.codeEmployee = codeEmployee;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.dayWork = dayWork;
        this.hourlySalary = hourlySalary;
    }
    public Employee (){}

    public abstract void cachTinhLuong();

}
