package vn.com.t3h.claim_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.mapper.UserMapper;
import vn.com.t3h.claim_manager.repository.UserRepository;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;
import vn.com.t3h.claim_manager.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        System.out.println("Retrieved Users: " + users);
        List<UserDTO> userDTOs = new ArrayList<>();

        userDTOs =  users.stream().map(entity -> userMapper.toDTO(entity)).toList();
        return userDTOs;
    }
}
