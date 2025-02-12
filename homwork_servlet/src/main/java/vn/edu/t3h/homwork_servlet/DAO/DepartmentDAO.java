package vn.edu.t3h.homwork_servlet.DAO;

import vn.edu.t3h.homwork_servlet.model.Department;

import java.util.List;

public interface DepartmentDAO {
    List<Department> getAllDepartments();
    List<Department> findByCondition(String departmentName, String location);
}
