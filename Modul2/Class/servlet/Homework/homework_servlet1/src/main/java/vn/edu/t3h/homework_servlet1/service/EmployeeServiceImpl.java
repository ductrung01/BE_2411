package vn.edu.t3h.homework_servlet1.service;

import vn.edu.t3h.homework_servlet1.DAO.EmployeeDAO;
import vn.edu.t3h.homework_servlet1.DAO.impl.EmployeeDAOImpl;
import vn.edu.t3h.homework_servlet1.model.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> getAllEmployees() {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        return employeeDAO.getEmployees();
    }


}
