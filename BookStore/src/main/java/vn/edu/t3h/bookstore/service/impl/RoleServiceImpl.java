package vn.edu.t3h.bookstore.service.impl;


import vn.edu.t3h.bookstore.dao.RoleDAO;
import vn.edu.t3h.bookstore.model.RoleModel;
import vn.edu.t3h.bookstore.service.RoleService;

public class RoleServiceImpl implements RoleService {
    private RoleDAO roleDao;

    public RoleServiceImpl(RoleDAO roleDao) {
        this.roleDao = roleDao;
    }
    @Override
    public RoleModel getRoleById(Integer roleId) {
        return roleDao.findRoleById(roleId);
    }
}
