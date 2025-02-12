package vn.edu.t3h.homwork_servlet.service;

import com.mysql.cj.util.StringUtils;
import vn.edu.t3h.homwork_servlet.DAO.EmployeeDAO;
import vn.edu.t3h.homwork_servlet.DAO.impl.EmployeeDAOImpl;
import vn.edu.t3h.homwork_servlet.model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;
   public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
       this.employeeDAO = employeeDAO;
   }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeDAO.getAllEmployees();
    }

    @Override
    public List<Employee> findByFilter(String name, String salary, String fromDate, String toDate, String positon) {
       if(StringUtils.isNullOrEmpty(name)){ // kiểm tra xem giá trị chuyền vào có trống hoặc null hay ko nếu có thì gán giá trị đó bằng null
        name = null;
       }
       if(StringUtils.isNullOrEmpty(salary)){
           salary = null;
       }
       if(StringUtils.isNullOrEmpty(fromDate)){
           fromDate = null;
       }
       if(StringUtils.isNullOrEmpty(toDate)){
           toDate = null;
       }
       if(StringUtils.isNullOrEmpty(positon)){
           positon = null;
       }
        List<Employee> employees =employeeDAO.findByCondition(name, salary, fromDate, toDate, positon);
       return employees;
    }

    @Override
    public List<Employee> addEmployeeService(String name, double salary, String positon, String departmentId, String hireDate) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setPosition(positon);
        employee.setDepartmentName(departmentId);
        employee.setHireDate(hireDate);
        employeeDAO.addEmployee(employee);
        return employeeDAO.getAllEmployees();
    }
}
