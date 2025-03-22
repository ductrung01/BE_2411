package vn.com.t3h.claim_manager.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.t3h.claim_manager.service.DTO.UserDTO;
import vn.com.t3h.claim_manager.service.UserService;

import java.util.List;
@RestController
@RequestMapping("/api/user")
public class UserResource {
    @Autowired
    private UserService userService;
@GetMapping()
    public ResponseEntity<List<UserDTO>> getListUser() {
     List<UserDTO> userDTOS = userService.getAllUsers();
     return  ResponseEntity.ok(userDTOS);


}

}
