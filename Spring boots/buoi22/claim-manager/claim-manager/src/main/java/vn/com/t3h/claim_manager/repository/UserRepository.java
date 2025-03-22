package vn.com.t3h.claim_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.t3h.claim_manager.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
