package vn.com.t3h.claim_manager.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.mapper.decorator.UserMapperDecorator;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-24T16:39:40+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
@Primary
public class UserMapperImpl extends UserMapperDecorator {

    @Autowired
    @Qualifier("delegate")
    private UserMapper delegate;

    @Override
    public UserEntity toEntity(UserDTO userDTO)  {
        return delegate.toEntity( userDTO );
    }
}
