package vn.edu.t3h.homwork_servlet.service;

import vn.edu.t3h.homwork_servlet.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    List<Department> findByFilter(String departmentName, String location);
}
