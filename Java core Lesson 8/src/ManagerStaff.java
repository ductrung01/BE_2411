public class ManagerStaff extends Employee{
    private double salaryOnDay = 200.000;
    private double salary;
    Employee employee = new Employee();
    @Override
    public void cachTinhLuong(){
        salary = salaryOnDay * employee.getHourlySalary();
    }
}
