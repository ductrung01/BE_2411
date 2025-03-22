package vn.com.t3h.claim_manager.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.t3h.claim_manager.service.ClaimService;
import vn.com.t3h.claim_manager.service.DTO.ClaimDTO;
import vn.com.t3h.claim_manager.service.DTO.respond.BaseRespond;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import java.util.List;

/**
 Đánh dấu đây là 1 controller trả về dữ liệu dạng json cho api
 */
@RestController
@RequestMapping("/api/claim")
public class ClaimResource {

    @Autowired
    private ClaimService claimService;
    // localhost:8080/api/claim
    @GetMapping()
    public ResponseEntity<BaseRespond<List<ClaimDTO>> >getListClaim(
            @RequestParam(required = false) String claimCode,
            @RequestParam(required = false) LocalDate fromDate,
            @RequestParam(required = false) LocalDate toDate,
            @RequestParam(required = false) String codeStatus,
            Pageable pageable
    ){
        BaseRespond<List<ClaimDTO>> respond = claimService.getClaims(claimCode,fromDate,toDate,codeStatus,pageable);
        return ResponseEntity.ok(respond);
    }
}
