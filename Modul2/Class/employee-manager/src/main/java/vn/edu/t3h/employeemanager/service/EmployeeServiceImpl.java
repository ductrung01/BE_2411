package vn.edu.t3h.employeemanager.service;

import vn.edu.t3h.employeemanager.dao.EmployeeDao;
import vn.edu.t3h.employeemanager.dao.impl.EmployeeDaoImpl;
import vn.edu.t3h.employeemanager.model.Employee;

import java.awt.*;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
//ở  tầng này đơn giản chỉ là tầng service đang gọi đến tầng DAO
    @Override
    public List<Employee> getAllEmployees() {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        return employeeDao.getAllEmployees();
    }
}
