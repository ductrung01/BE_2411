package vn.com.t3h.claim_manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import vn.com.t3h.claim_manager.entity.UserEntity;
import vn.com.t3h.claim_manager.mapper.UserMapper;
import vn.com.t3h.claim_manager.repository.UserRepository;
import vn.com.t3h.claim_manager.service.DTO.ClaimDTO;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;
import vn.com.t3h.claim_manager.service.DTO.respond.BaseRespond;
import vn.com.t3h.claim_manager.service.UserService;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public BaseRespond<List<UserDTO>> getAllUsers(
            String code,
            LocalDateTime createdDate,
            String address,
            Pageable pageable) {

        BaseRespond<List<UserDTO>> respond = new BaseRespond<>();

        // Kiểm tra các tham số đầu vào
        if (StringUtils.isEmpty(code) && StringUtils.isEmpty(address) && createdDate == null) {
            Page<UserEntity> userEntityPage = userRepository.findAll(pageable);
            List<UserDTO> userDTOs = userEntityPage.stream()
                    .map(userMapper::toDTO)
                    .toList();

            respond.setData(userDTOs);
            respond.setMessage("Success");
            respond.setCode(HttpStatus.OK.value());
            respond.setTotalElement(userEntityPage.getTotalElements());
            respond.setTotalPage(userEntityPage.getTotalPages());
            respond.setPageSize(userEntityPage.getSize());
            respond.setPageIndex(userEntityPage.getNumber());

            return respond;
        }

        Page<UserEntity> userEntityPage = userRepository.findByCondition(code, createdDate, address, pageable);
        List<UserDTO> userDTOs = userEntityPage.stream()
                .map(userMapper::toDTO)
                .toList();

        respond.setData(userDTOs);
        respond.setMessage("Success");
        respond.setCode(HttpStatus.OK.value());
        respond.setTotalElement(userEntityPage.getTotalElements());
        respond.setTotalPage(userEntityPage.getTotalPages());
        respond.setPageSize(userEntityPage.getSize());
        respond.setPageIndex(userEntityPage.getNumber());

        return respond;
    }


}
