package vn.com.t3h.claim_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.t3h.claim_manager.entity.RoleEntity;

import javax.management.relation.Role;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByCodeAndDeletedIsFalse(String code);
}
