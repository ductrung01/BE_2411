package vn.com.t3h.dao;

import vn.com.t3h.entity.RoleEntity;

public interface RoleRepository {
    RoleEntity findByRoleName(String roleName);
}
