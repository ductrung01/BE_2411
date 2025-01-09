package vn.edu.t3h.qlns.dao.impl;

import vn.edu.t3h.qlns.dao.EmployeeDao;
import vn.edu.t3h.qlns.model.Employee;

import java.util.List;

public class EmployeeDaoimpl implements EmployeeDao {
    @Override
    List<Employee> getAllEmployee();
}
