package vn.com.t3h.claim_manager.mapper.decorator;

import java.util.stream.Collectors;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import vn.com.t3h.claim_manager.entity.RoleEntity;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.mapper.UserMapper;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;
import vn.com.t3h.claim_manager.service.FileService;

@Component
public abstract class UserMapperDecorator implements UserMapper {

  @Autowired
  @Qualifier("delegate")
  private UserMapper userMapper;
  @Autowired
  private FileService fileService;

  @Override
  public UserDTO toDto(UserEntity userEntity) {
    UserDTO userDTO = userMapper.toDto(userEntity);
    String fileBase64 = fileService.getBase64FromPath(userEntity.getPathAvatar());
    userDTO.setStringBase64Avatar(fileBase64);
    String roleName = userEntity.getRoles().stream().map(RoleEntity::getName).collect(Collectors.joining(","));
    userDTO.setRoleName(roleName);
  return userDTO;
  }
}
