package vn.edu.t3h.homwork_servlet.DAO;

import vn.edu.t3h.homwork_servlet.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    List<Employee> findByCondition(String name,String salary, String fromDate, String toDate, String positon);
    public void addEmployee(Employee employee);
}
