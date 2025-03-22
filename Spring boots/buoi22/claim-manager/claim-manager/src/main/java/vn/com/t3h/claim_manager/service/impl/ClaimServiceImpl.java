package vn.com.t3h.claim_manager.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.com.t3h.claim_manager.entity.ClaimEntity;
import vn.com.t3h.claim_manager.mapper.ClaimMapper;
import vn.com.t3h.claim_manager.repository.ClaimRepository;
import vn.com.t3h.claim_manager.service.ClaimService;
import vn.com.t3h.claim_manager.service.DTO.ClaimDTO;
import vn.com.t3h.claim_manager.service.DTO.respond.BaseRespond;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;
    @Autowired
    private ClaimMapper claimMapper;

    @Override
    public BaseRespond<List<ClaimDTO>>getClaims(
                                 String claimCode,
                                 LocalDate fromDate,
                                 LocalDate toDate,
                                 String codeStatus,
                                 Pageable pageable ){
        if (StringUtils.isEmpty(claimCode)){
            claimCode = null;
        }
        if (StringUtils.isEmpty(codeStatus)){
            codeStatus = null;
        }
        // 5 result entity class
        Page<ClaimEntity> pageEntity = claimRepository.findByCondition(claimCode,fromDate,toDate,codeStatus,pageable);
        List<ClaimDTO> claimDTOs = new ArrayList<>();
        claimDTOs = pageEntity.map(entity -> claimMapper.toDTO(entity)).stream().toList();
        BaseRespond<List<ClaimDTO>> respond = new BaseRespond<>();
        respond.setData(claimDTOs);
        respond.setMessage("Success");
        respond.setCode(HttpStatus.OK.value());
        respond.setTotalElement(pageEntity.getTotalElements());
        respond.setTotalPage(pageEntity.getTotalPages());
        respond.setPageSize(pageable.getPageSize());
        respond.setPageIndex(pageable.getPageNumber());
        return respond;
    }
}
//        Cách 1:
/*     for (int i = 0; i < claimEntities.size(); i++) {
            ClaimEntity claimEntity = claimEntities.get(i);
            ClaimDTO claimDTO = new ClaimDTO();
            claimDTO.setCode(claimEntity.getCode());//claim -> code
            claimDTO.setCustomerName(claimEntity.getCustomerEntity().getName());// customer -> name
            claimDTO.setNameProduct(claimEntity.getInsuranceProductEntity().getName());//insurance_product -> name
            claimDTO.setClaimDate(claimEntity.getClaimDate());//claim -> claim_date
            claimDTO.setCoverageProduct(claimEntity.getInsuranceProductEntity().getCoverage());//insurance_product -> coverage
            claimDTO.setStatusName(claimEntity.getClaimStatusEntity().getDescription());//claim_status -> description
            claimDTOs.add(claimDTO);
        }

    */