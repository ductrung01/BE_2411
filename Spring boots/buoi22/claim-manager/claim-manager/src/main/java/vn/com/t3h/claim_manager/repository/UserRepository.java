package vn.com.t3h.claim_manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.t3h.claim_manager.entity.UserEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT u FROM UserEntity u " +
            "WHERE (:code IS NULL OR u.code = :code) " +
            "AND (:fromDate IS NULL OR u.createdDate >= :fromDate) " +
            "AND (:toDate is null or u.createdDate <= :toDate)"+
            "AND (:phone is null or u.phone = :phone)"
    )
    Page<UserEntity> findByCondition(
            @Param("code") String code,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate")  LocalDate toDate,
            @Param("phone") String phone,
            Pageable pageable
    );



}
