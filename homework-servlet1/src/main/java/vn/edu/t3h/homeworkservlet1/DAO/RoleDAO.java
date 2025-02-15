package vn.edu.t3h.homeworkservlet1.DAO;

import vn.edu.t3h.homeworkservlet1.model.RoleModel;

public interface RoleDAO {
    RoleModel findRoleById(Integer roleId);
}
