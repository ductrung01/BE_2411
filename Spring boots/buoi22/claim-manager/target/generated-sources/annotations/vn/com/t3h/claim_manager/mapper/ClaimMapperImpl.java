package vn.com.t3h.claim_manager.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.com.t3h.claim_manager.entity.ClaimEntity;
import vn.com.t3h.claim_manager.entity.ClaimStatusEntity;
import vn.com.t3h.claim_manager.entity.CustomerEntity;
import vn.com.t3h.claim_manager.entity.InsuranceProductEntity;
import vn.com.t3h.claim_manager.service.DTO.ClaimDTO;
import vn.com.t3h.claim_manager.service.DTO.ClaimDetailDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-24T16:39:40+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class ClaimMapperImpl implements ClaimMapper {

    @Override
    public ClaimDTO toDTO(ClaimEntity claimEntity) {
        if ( claimEntity == null ) {
            return null;
        }

        ClaimDTO claimDTO = new ClaimDTO();

        claimDTO.setCustomerName( claimEntityCustomerEntityName( claimEntity ) );
        claimDTO.setNameProduct( claimEntityInsuranceProductEntityName( claimEntity ) );
        claimDTO.setCoverageProduct( claimEntityInsuranceProductEntityCoverage( claimEntity ) );
        claimDTO.setStatusName( claimEntityClaimStatusEntityDescription( claimEntity ) );
        claimDTO.setCode( claimEntity.getCode() );
        claimDTO.setClaimDate( claimEntity.getClaimDate() );

        return claimDTO;
    }

    @Override
    public ClaimDetailDTO toDetailDTO(ClaimEntity claimEntity) {
        if ( claimEntity == null ) {
            return null;
        }

        ClaimDetailDTO claimDetailDTO = new ClaimDetailDTO();

        claimDetailDTO.setNameCustomer( claimEntityCustomerEntityName( claimEntity ) );
        claimDetailDTO.setEmail( claimEntityCustomerEntityEmail( claimEntity ) );
        claimDetailDTO.setPhoneNumber( claimEntityCustomerEntityPhoneNumber( claimEntity ) );
        claimDetailDTO.setNameInsuranceProduct( claimEntityInsuranceProductEntityName( claimEntity ) );
        claimDetailDTO.setStatus( claimEntityClaimStatusEntityDescription( claimEntity ) );
        claimDetailDTO.setCode( claimEntity.getCode() );
        claimDetailDTO.setclaimDate( claimEntity.getClaimDate() );
        claimDetailDTO.setDescription( claimEntity.getDescription() );

        return claimDetailDTO;
    }

    private String claimEntityCustomerEntityName(ClaimEntity claimEntity) {
        if ( claimEntity == null ) {
            return null;
        }
        CustomerEntity customerEntity = claimEntity.getCustomerEntity();
        if ( customerEntity == null ) {
            return null;
        }
        String name = customerEntity.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String claimEntityInsuranceProductEntityName(ClaimEntity claimEntity) {
        if ( claimEntity == null ) {
            return null;
        }
        InsuranceProductEntity insuranceProductEntity = claimEntity.getInsuranceProductEntity();
        if ( insuranceProductEntity == null ) {
            return null;
        }
        String name = insuranceProductEntity.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String claimEntityInsuranceProductEntityCoverage(ClaimEntity claimEntity) {
        if ( claimEntity == null ) {
            return null;
        }
        InsuranceProductEntity insuranceProductEntity = claimEntity.getInsuranceProductEntity();
        if ( insuranceProductEntity == null ) {
            return null;
        }
        String coverage = insuranceProductEntity.getCoverage();
        if ( coverage == null ) {
            return null;
        }
        return coverage;
    }

    private String claimEntityClaimStatusEntityDescription(ClaimEntity claimEntity) {
        if ( claimEntity == null ) {
            return null;
        }
        ClaimStatusEntity claimStatusEntity = claimEntity.getClaimStatusEntity();
        if ( claimStatusEntity == null ) {
            return null;
        }
        String description = claimStatusEntity.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private String claimEntityCustomerEntityEmail(ClaimEntity claimEntity) {
        if ( claimEntity == null ) {
            return null;
        }
        CustomerEntity customerEntity = claimEntity.getCustomerEntity();
        if ( customerEntity == null ) {
            return null;
        }
        String email = customerEntity.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }

    private String claimEntityCustomerEntityPhoneNumber(ClaimEntity claimEntity) {
        if ( claimEntity == null ) {
            return null;
        }
        CustomerEntity customerEntity = claimEntity.getCustomerEntity();
        if ( customerEntity == null ) {
            return null;
        }
        String phoneNumber = customerEntity.getPhoneNumber();
        if ( phoneNumber == null ) {
            return null;
        }
        return phoneNumber;
    }
}
