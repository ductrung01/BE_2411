package vn.com.t3h.claim_manager.service;

import vn.com.t3h.claim_manager.service.DTO.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
}
