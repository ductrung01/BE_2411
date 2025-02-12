package vn.edu.t3h.homeworkservlet1.service.impl;

import com.mysql.cj.util.StringUtils;
import vn.edu.t3h.homeworkservlet1.DAO.EmployeeDAO;
import vn.edu.t3h.homeworkservlet1.model.Employee;
import vn.edu.t3h.homeworkservlet1.service.EmployeeService;

import java.sql.Connection;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public List<Employee> findByCondition(String name, String salary, String fromDate, String toDate, String position) {
        if(StringUtils.isNullOrEmpty(name)){
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
        if(StringUtils.isNullOrEmpty(position)){
            position = null;
        }
        return employeeDAO.findByCondition(name, salary, fromDate, toDate, position);

    }

    @Override
    public int insertEmployee(Employee employee) {
        return employeeDAO.insertEmployee(employee);
    }

    @Override
    public int deleteEmployeeById(int id) {
        return employeeDAO.deleteEmployeeById(id);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }


}
