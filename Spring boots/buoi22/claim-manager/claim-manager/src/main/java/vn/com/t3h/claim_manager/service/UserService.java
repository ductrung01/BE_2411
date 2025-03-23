package vn.com.t3h.claim_manager.service;

import org.springframework.data.domain.Pageable;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;
import vn.com.t3h.claim_manager.service.DTO.respond.BaseRespond;

import java.time.LocalDateTime;
import java.util.List;
public interface UserService {
   BaseRespond< List<UserDTO>> getAllUsers(String code, LocalDateTime createdDate, String address, Pageable pageable);
}

