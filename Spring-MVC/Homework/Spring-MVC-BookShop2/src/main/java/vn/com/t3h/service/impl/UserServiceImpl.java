package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.UserRepository;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public List<UserEntity> searchUserByName(String userName,String fullName, String identityNumber) {
        return userRepository.findByUserName(userName,fullName,identityNumber);
    }
}
