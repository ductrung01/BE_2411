package vn.edu.t3h.homework_servlet1.service;

import vn.edu.t3h.homework_servlet1.DAO.DepartmentDAO;
import vn.edu.t3h.homework_servlet1.DAO.impl.DepartmentDAOImpl;
import vn.edu.t3h.homework_servlet1.model.Department;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    @Override
    public List<Department> getAllDepartments() {
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        return departmentDAO.getAllDepartments();
    }
}
