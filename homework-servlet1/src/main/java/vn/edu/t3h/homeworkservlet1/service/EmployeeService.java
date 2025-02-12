package vn.edu.t3h.homeworkservlet1.service;

import vn.edu.t3h.homeworkservlet1.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    List<Employee> findByCondition(String name, String salary, String fromDate, String toDate,String position);
    int insertEmployee(Employee employee);
    int deleteEmployeeById(int id);
    Employee getEmployeeById(int id);
    int updateEmployee(Employee employee);
}
