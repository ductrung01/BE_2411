package vn.edu.t3h.homeworkservlet1.DAO;

import vn.edu.t3h.homeworkservlet1.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();
    int insertEmployee(Employee employee);
    List<Employee> findByCondition(String name, String salary, String fromDate, String toDate, String position);
    int deleteEmployeeById(int id);
    Employee getEmployeeById(int id);
    int updateEmployee(Employee employee);
}
