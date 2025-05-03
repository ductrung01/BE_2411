package vn.com.t3h.claim_manager.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.mapper.decorator.UserMapperDecorator;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;

@Mapper(componentModel = "spring")
@DecoratedWith(UserMapperDecorator.class)

public interface UserMapper {
    UserEntity toEntity(UserDTO userDTO);

    UserDTO toDto(UserEntity userEntity);

}
