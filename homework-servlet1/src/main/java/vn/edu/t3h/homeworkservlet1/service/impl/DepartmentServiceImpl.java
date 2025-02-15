package vn.edu.t3h.homeworkservlet1.service.impl;

import vn.edu.t3h.homeworkservlet1.DAO.DepartmentDAO;
import vn.edu.t3h.homeworkservlet1.model.Department;
import vn.edu.t3h.homeworkservlet1.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
   private DepartmentDAO departmentDAO;// Tiem phu thuoc
   public DepartmentServiceImpl (DepartmentDAO departmentDAO) {
       this.departmentDAO = departmentDAO;
   }
    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }
}
