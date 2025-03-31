package vn.com.t3h.claim_manager.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;
import vn.com.t3h.claim_manager.service.DTO.respond.BaseResponse;
import vn.com.t3h.claim_manager.service.DTO.respond.Respond;
import vn.com.t3h.claim_manager.service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.awt.*;

@RestController
@RequestMapping("/api/user")
public class UserResource {
    @Autowired
    private UserService userService;
//    @PostMapping("/user/create")
//    public ResponseEntity<Respond<UserDTO >> createUser(@RequestBody UserDTO userDTO) {
//        Respond<UserDTO> respond = userService.saveUser(userDTO);
//        return ResponseEntity.ok(respond);
//    }
    @GetMapping()
    public ResponseEntity<BaseResponse<List<UserDTO>>> getAllUser(
            @RequestParam(required = false) String code,
            @RequestParam(required = false)LocalDate fromDate,
            @RequestParam(required = false)LocalDate toDate,
            @RequestParam(required = false) String phone,
            Pageable pageable
            ){

       BaseResponse<List<UserDTO>> userDTOS = userService.findAll(code,fromDate,toDate,phone ,pageable);
        return ResponseEntity.ok(userDTOS);
    }
//    @GetMapping()
//    public ResponseEntity<BaseRespond<List<UserDTO>>> getListUser(
//            @RequestParam(required = false) String code,
//            @RequestParam(required = false) LocalDateTime createdDate,
//            @RequestParam(required = false) String address,
//            Pageable pageable) {
//
//        BaseRespond<List<UserDTO>> userDTOS = userService.getAllUsers(code, createdDate, address, pageable);
//        return ResponseEntity.ok(userDTOS);
//    }
}
