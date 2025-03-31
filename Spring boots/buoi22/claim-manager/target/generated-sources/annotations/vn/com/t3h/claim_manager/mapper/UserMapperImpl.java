package vn.com.t3h.claim_manager.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-31T14:06:47+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setCreatedDate( userEntity.getCreatedDate() );
        if ( userEntity.getId() != null ) {
            userDTO.setId( userEntity.getId() );
        }
        userDTO.setUsername( userEntity.getUsername() );
        userDTO.setCode( userEntity.getCode() );
        userDTO.setFirstName( userEntity.getFirstName() );
        userDTO.setLastName( userEntity.getLastName() );
        userDTO.setPhone( userEntity.getPhone() );
        userDTO.setAddress( userEntity.getAddress() );

        userDTO.setFullName( userEntity.getFirstName() + ' ' + userEntity.getLastName() );

        return userDTO;
    }

    @Override
    public UserEntity toUserEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDTO.getId() );
        userEntity.setUsername( userDTO.getUsername() );
        userEntity.setCode( userDTO.getCode() );
        userEntity.setFirstName( userDTO.getFirstName() );
        userEntity.setLastName( userDTO.getLastName() );
        userEntity.setPhone( userDTO.getPhone() );
        userEntity.setAddress( userDTO.getAddress() );
        userEntity.setCreatedDate( userDTO.getCreatedDate() );

        return userEntity;
    }
}
