package vn.com.t3h.claim_manager.service;

import org.springframework.data.domain.Pageable;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;
import vn.com.t3h.claim_manager.service.DTO.respond.BaseResponse;
import vn.com.t3h.claim_manager.service.DTO.respond.Response;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

  //   Respond< List<UserDTO>> getAllUsers(String code, LocalDateTime createdDate, String address, Pageable pageable);
  Response<UserDTO> saveUser(UserDTO userDTO);

  BaseResponse<List<UserDTO>> findAll(String code, LocalDate fromDate, LocalDate toDate,
      String phone, Pageable pageable);

  Response<UserDTO> getDetailUser(Long id);
  Response<UserDTO> getCurrentUser();

}

