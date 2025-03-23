package vn.com.t3h.claim_manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.t3h.claim_manager.entity.UserEntity;

import java.time.LocalDateTime;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT u FROM UserEntity u " +
            "WHERE (:code IS NULL OR u.code = :code) " +
            "AND (:createdDate IS NULL OR u.createdDate = :createdDate) " +
            "AND (:address IS NULL OR u.address = :address)")
    Page<UserEntity> findByCondition(
            @Param("code") String code,
            @Param("createdDate") LocalDateTime createdDate,
            @Param("address") String address,
            Pageable pageable
    );



}
