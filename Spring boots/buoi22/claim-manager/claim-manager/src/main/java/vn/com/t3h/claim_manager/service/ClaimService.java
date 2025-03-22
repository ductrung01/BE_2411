package vn.com.t3h.claim_manager.service;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.t3h.claim_manager.service.DTO.ClaimDTO;
import vn.com.t3h.claim_manager.service.DTO.respond.BaseRespond;

import java.time.LocalDate;
import  java.util.List;
public interface ClaimService {
  BaseRespond<List<ClaimDTO>> getClaims(
           String claimCode,
           LocalDate fromDate,
           LocalDate toDate,
           String codeStatus,
           Pageable pageable
    );
}
