package vn.com.t3h.claim_manager.security;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.com.t3h.claim_manager.entity.RoleEntity;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.repository.RoleRepository;
import vn.com.t3h.claim_manager.repository.UserRepository;
import vn.com.t3h.claim_manager.utils.Constant;

@Service
public class UserDetaiServiceCustom implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  /*
* Đây là method dau tien se duoc goi den khi user click login tren ui
* String username(UserDetails) chinh la username user nhap tren ui login
B1. Phải thực hiện lấy ra UserEntity từ username
B2. Lấy ra danh sách quyền của user từ userEntity
B3. Tạo ra user detail (UserDetails )của thử viện spring security từ các thông tin của userEntity như
username, password, danh sách quyền
B4. Gửi userDetail đã tạo ra từ bước 3 cho spring security

* */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (StringUtils.isEmpty(username)) {
      throw new UsernameNotFoundException("Username is empty");
    }

    // Lấy ra UserEntity từ username
    UserEntity userEntity = userRepository.findByUsername(username);
    if (userEntity == null) {
      throw new UsernameNotFoundException("Username not found");
    }

    // Lấy ra danh sách quyền của user từ userEntity
    Set<RoleEntity> roleEntities = roleRepository.findByUserName(username);
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>(); // Quyền của Spring Security
    for (RoleEntity roleEntity : roleEntities) {
      grantedAuthorities.add(new SimpleGrantedAuthority(Constant.PREFIX_ROLE + roleEntity.getCode())); // ROLE_ADMIN, ROLE_USER
    }

    // Tạo ra UserDetails
    UserDetails userDetails = new User(userEntity.getUsername(), userEntity.getPassword(), grantedAuthorities);
    return userDetails;
  }

}
