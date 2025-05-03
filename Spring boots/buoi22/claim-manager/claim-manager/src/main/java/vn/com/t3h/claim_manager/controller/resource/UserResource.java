package vn.com.t3h.claim_manager.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;
import vn.com.t3h.claim_manager.service.DTO.respond.BaseResponse;
import vn.com.t3h.claim_manager.service.DTO.respond.ReponsePage;
import vn.com.t3h.claim_manager.service.DTO.respond.Response;
import vn.com.t3h.claim_manager.service.UserService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResource {
    @Autowired
    private UserService userService;

        @PostMapping("/create")
    public ResponseEntity<Response<UserDTO >> createUser(@RequestBody UserDTO userDTO) {
            Response<UserDTO> respond = userService.saveUser(userDTO);
        return ResponseEntity.ok(respond);
    }
    @GetMapping()
    public ResponseEntity<BaseResponse<List<UserDTO>>> getAllUser(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) LocalDate fromDate,
            @RequestParam(required = false) LocalDate toDate,
            @RequestParam(required = false) String phone,
            Pageable pageable
    ) {

        BaseResponse<List<UserDTO>> userDTOS = userService.findAll(code, fromDate, toDate, phone, pageable);
        return ResponseEntity.ok(userDTOS);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<UserDTO>> getUserById(@PathVariable Long id) {
            Response<UserDTO> response = userService.getDetailUser(id);
            return ResponseEntity.ok(response);
    }
    @GetMapping("/current-user")
    public ResponseEntity<Response<UserDTO>> getCurrentUser() {
            return ResponseEntity.ok(userService.getCurrentUser());
    }
}
