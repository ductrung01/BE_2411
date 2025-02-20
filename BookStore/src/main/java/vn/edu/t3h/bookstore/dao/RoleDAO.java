package vn.edu.t3h.bookstore.dao;


import vn.edu.t3h.bookstore.model.RoleModel;

public interface RoleDAO {
    RoleModel findRoleById(Integer roleId);
}
