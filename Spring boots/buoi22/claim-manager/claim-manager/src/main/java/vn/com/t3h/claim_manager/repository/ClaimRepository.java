package vn.com.t3h.claim_manager.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.t3h.claim_manager.entity.ClaimEntity;

import java.time.LocalDate;


// triên khai spring data jpa
@Repository
public interface ClaimRepository extends JpaRepository<ClaimEntity,Long> {
//cau  lenhj truy van thuong
            /*
    select * from claim c
         inner join claim_status status on c.status_id = status.id
        where (:claimCode is null or c.code =:claimCode)
        and (:fromDate is null or c.claim_date >= :fromDate)
        and (:toDate is null or c.claim_date <= :toDate)
        and (:codeStatus is null or status.code =:codeStatus)
        limit :pageSize offset :pageIndex;
     */
//    Truy vaans bang jpa
    @Query(value ="select c from ClaimEntity c " + // select * from claim c
            " inner join c.claimStatusEntity status" // inner join claim_status status on c.status_id = status.id
            + " where (:claimCode is null or c.code = :claimCode) " +
            "and (:fromDate is null or c.claimDate >= :fromDate) " +
            "and (:toDate is null or c.claimDate <= :toDate)" +
            "and (:codeStatus is null or status.code = :codeStatus)"
    )
    Page<ClaimEntity> findByCondition(
            @Param("claimCode") String claimCode,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("codeStatus") String codeStatus,

            Pageable pageable);
}