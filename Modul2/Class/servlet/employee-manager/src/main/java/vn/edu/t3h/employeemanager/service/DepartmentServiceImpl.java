package vn.edu.t3h.employeemanager.service;

import vn.edu.t3h.employeemanager.dao.DepartmentDao;
import vn.edu.t3h.employeemanager.dao.impl.DepartmentDaoImpl;
import vn.edu.t3h.employeemanager.model.Department;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    @Override
    public List<Department> getAllDepartments() {
        DepartmentDao departmentDao = new DepartmentDaoImpl();
        return departmentDao.getAllDepartments();
    }
}
