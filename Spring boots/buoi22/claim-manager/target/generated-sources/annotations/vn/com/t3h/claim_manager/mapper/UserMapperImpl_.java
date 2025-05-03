package vn.com.t3h.claim_manager.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-24T16:39:40+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
@Qualifier("delegate")
public class UserMapperImpl_ implements UserMapper {

    @Override
    public UserEntity toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDTO.getId() );
        userEntity.setUsername( userDTO.getUsername() );
        userEntity.setPassword( userDTO.getPassword() );
        userEntity.setCode( userDTO.getCode() );
        userEntity.setEmail( userDTO.getEmail() );
        userEntity.setFirstName( userDTO.getFirstName() );
        userEntity.setLastName( userDTO.getLastName() );
        userEntity.setPhone( userDTO.getPhone() );
        userEntity.setAddress( userDTO.getAddress() );

        return userEntity;
    }

    @Override
    public UserDTO toDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( userEntity.getId() );
        userDTO.setUsername( userEntity.getUsername() );
        userDTO.setPassword( userEntity.getPassword() );
        userDTO.setCode( userEntity.getCode() );
        userDTO.setEmail( userEntity.getEmail() );
        userDTO.setFirstName( userEntity.getFirstName() );
        userDTO.setLastName( userEntity.getLastName() );
        userDTO.setPhone( userEntity.getPhone() );
        userDTO.setAddress( userEntity.getAddress() );

        return userDTO;
    }
}
