package vn.edu.t3h.homwork_servlet.service;

import com.mysql.cj.util.StringUtils;
import vn.edu.t3h.homwork_servlet.DAO.DepartmentDAO;
import vn.edu.t3h.homwork_servlet.DAO.impl.DepartmentDAOImpl;
import vn.edu.t3h.homwork_servlet.model.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentDAO departmentDAO ;
    public DepartmentServiceImpl(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<Department>();
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        return departmentDAO.getAllDepartments();
    }

    @Override
    public List<Department> findByFilter(String departmentName, String location) {
        if(StringUtils.isNullOrEmpty(departmentName)){
            departmentName = null;
        }
        if(StringUtils.isNullOrEmpty(location)){
            location = null;
        }
        List<Department>departments = departmentDAO.findByCondition(departmentName,location);
        return departments;
    }
}
