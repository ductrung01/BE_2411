package vn.com.t3h.claim_manager.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;
import vn.com.t3h.claim_manager.service.DTO.respond.BaseRespond;
import vn.com.t3h.claim_manager.service.UserService;
import org.springframework.data.domain.Pageable;


import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/api/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<BaseRespond<List<UserDTO>>> getListUser(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) LocalDateTime createdDate,
            @RequestParam(required = false) String address,
            Pageable pageable) {

        BaseRespond<List<UserDTO>> userDTOS = userService.getAllUsers(code, createdDate, address, pageable);
        return ResponseEntity.ok(userDTOS);
    }
}
