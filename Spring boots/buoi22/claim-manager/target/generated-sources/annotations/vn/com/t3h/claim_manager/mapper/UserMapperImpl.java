package vn.com.t3h.claim_manager.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-25T23:56:14+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        String code = null;
        String username = null;
        String address = null;
        LocalDateTime createdDate = null;

        code = userEntity.getCode();
        username = userEntity.getUsername();
        address = userEntity.getAddress();
        createdDate = userEntity.getCreatedDate();

        String fullName = userEntity.getFirstName() + ' ' + userEntity.getLastName();

        UserDTO userDTO = new UserDTO( code, username, fullName, createdDate, address );

        return userDTO;
    }
}
