package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.IdentityCardRepository;
import vn.com.t3h.dao.RoleRepository;
import vn.com.t3h.dao.UserRepository;
import vn.com.t3h.entity.IdentityCardEntity;
import vn.com.t3h.entity.RoleEntity;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.model.ProductDTO;
import vn.com.t3h.model.UserDTO;
import vn.com.t3h.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private IdentityCardRepository identityCardRepository;
    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> userEntities = userRepository.getAllUser();
        List<UserDTO> userDTOs = userEntities.stream().map(data -> {
            UserDTO userDTO = new UserDTO(
                    data.getId(),
                    data.getUsername(),
                    data.getPassword(),
                    null,
                    null,
                    null,
                    data.getIdentityCardEntity().getIdentityNumber()
            );
            if (data.getIdentityCardEntity() != null) {
                userDTO.setFullName(data.getIdentityCardEntity().getFullName());
                userDTO.setAddress(data.getIdentityCardEntity().getAddress());
            }
            if (data.getRoles() != null && !data.getRoles().isEmpty()) {
                String roleNames = data.getRoles().stream()
                        .map(RoleEntity::getRole_name)
                        .collect(Collectors.joining(", "));
                userDTO.setRole_name(roleNames);
            }

            return userDTO;
        }).collect(Collectors.toList());

        return userDTOs;
    }

    @Override
    public List<UserDTO> searchUserByName(String userName, String fullName, String identityNumber) {
        List<UserEntity> userEntities = userRepository.findByUserName(userName, fullName, identityNumber);
        List<UserDTO> userDTOs = userEntities.stream().map(data -> {
            UserDTO userDTO = new UserDTO(
                    data.getId(),
                    data.getUsername(),
                    data.getPassword(),
                    null,
                    null,
                    null,
                    data.getIdentityCardEntity().getIdentityNumber()
            );

            if (data.getIdentityCardEntity() != null) {
                userDTO.setFullName(data.getIdentityCardEntity().getFullName());
                userDTO.setAddress(data.getIdentityCardEntity().getAddress());
            }
            if (data.getRoles() != null && !data.getRoles().isEmpty()) {
                String roleNames = data.getRoles().stream()
                        .map(RoleEntity::getRole_name)
                        .collect(Collectors.joining(", "));
                userDTO.setRole_name(roleNames);
            }

            return userDTO;
        }).collect(Collectors.toList());

        return userDTOs;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUserName());
        userEntity.setPassword(userDTO.getPassword());


        IdentityCardEntity identityCardEntity = new IdentityCardEntity();
        identityCardEntity.setFullName(userDTO.getFullName());
        identityCardEntity.setAddress(userDTO.getAddress());
        identityCardEntity.setIdentityNumber(userDTO.getIdentityNumber());
        identityCardEntity.setUser(userEntity);

        userEntity.setIdentityCardEntity(identityCardEntity);


        Set<RoleEntity> roles = new HashSet<>();
        for (String roleName : userDTO.getRole_name().split(", ")) {
            RoleEntity role = roleRepository.findByRoleName(roleName);
            if (role != null) {
                roles.add(role);
            }
        }
        userEntity.setRoles(roles);
        userDTO.setId(userEntity.getId());
        userRepository.saveUser(userEntity);


        return userDTO;
    }

    @Override
    public UserDTO findByID(Long id) {
        UserEntity user = userRepository.findById(id);
        return convertToDTO(user);
    }
    private UserDTO convertToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                null,
                null,
                null,
                userEntity.getIdentityCardEntity() != null ? userEntity.getIdentityCardEntity().getIdentityNumber() : null
        );

        if (userEntity.getIdentityCardEntity() != null) {
            userDTO.setFullName(userEntity.getIdentityCardEntity().getFullName());
            userDTO.setAddress(userEntity.getIdentityCardEntity().getAddress());
        }

        if (userEntity.getRoles() != null && !userEntity.getRoles().isEmpty()) {
            String roleNames = userEntity.getRoles().stream()
                    .map(RoleEntity::getRole_name)
                    .collect(Collectors.joining(", "));
            userDTO.setRole_name(roleNames);
        }

        return userDTO;
    }


    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
         userRepository.deleteById(id);
    }








}

