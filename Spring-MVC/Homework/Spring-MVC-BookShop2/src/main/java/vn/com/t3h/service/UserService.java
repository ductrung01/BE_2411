package vn.com.t3h.service;
import vn.com.t3h.entity.UserEntity;

import java.util.List;
public interface UserService {
    List<UserEntity> getAllUser();
    public List<UserEntity> searchUserByName(String userName,String fullName , String identityNumber);
}
