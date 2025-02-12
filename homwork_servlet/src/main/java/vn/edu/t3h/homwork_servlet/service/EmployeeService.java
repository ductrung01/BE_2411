package vn.edu.t3h.homwork_servlet.service;

import vn.edu.t3h.homwork_servlet.model.Employee;
import java.util.List;
public interface EmployeeService {
   List<Employee> getAllEmployees();
   List<Employee> findByFilter(String name,String salary, String fromDate, String toDate, String positon);
   List<Employee> addEmployeeService(String name, double salary,String positon, String departmentId, String hireDate);
}
