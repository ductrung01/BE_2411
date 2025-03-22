package vn.com.t3h.claim_manager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(UserEntity userEntity);
}
