package vn.com.t3h.dao;

import vn.com.t3h.entity.UserEntity;
import java.util.List;
public interface UserRepository {
    List<UserEntity> getAllUser();
    public List<UserEntity> findByUserName(String userName,String fullName , String identityNumber);
}
