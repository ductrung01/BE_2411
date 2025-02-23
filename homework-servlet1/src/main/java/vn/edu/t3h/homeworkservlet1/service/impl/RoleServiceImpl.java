package vn.edu.t3h.homeworkservlet1.service.impl;

import vn.edu.t3h.homeworkservlet1.DAO.RoleDAO;
import vn.edu.t3h.homeworkservlet1.model.RoleModel;
import vn.edu.t3h.homeworkservlet1.service.RoleService;

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
