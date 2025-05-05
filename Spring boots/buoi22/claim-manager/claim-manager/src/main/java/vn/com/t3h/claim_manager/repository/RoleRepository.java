package vn.com.t3h.claim_manager.repository;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.t3h.claim_manager.entity.RoleEntity;

import javax.management.relation.Role;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByCodeAndDeletedIsFalse(String code);
    @Query("SELECT r FROM RoleEntity r JOIN r.users u WHERE u.username = :username")
    Set<RoleEntity> findByUserName(@Param("username") String username);


}
