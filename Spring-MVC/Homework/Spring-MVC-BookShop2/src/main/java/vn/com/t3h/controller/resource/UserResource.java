package vn.com.t3h.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.model.ProductDTO;
import vn.com.t3h.model.UserDTO;
import vn.com.t3h.service.UserService;
import java.util.List;
@Controller
@RestController("/api")
public class UserResource {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOS = userService.getAllUser();
        if (userDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(userDTOS);
    }
    @GetMapping("/users-search")
    public ResponseEntity<List<UserDTO>> searchUser(@RequestParam(required = false ,name = "userName") String userName,
                                                       @RequestParam(required = false, name = "fullName") String fullName,
                                                        @RequestParam(required = false,name = "identityNumber") String identityNumber)
    {
        List<UserDTO> userDTOS = userService.searchUserByName(userName,fullName,identityNumber);
        if(userDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userDTOS);

    }
    @PostMapping("/add")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
       UserDTO userDTOSaved = userService.addUser(userDTO);
       return ResponseEntity.ok(userDTOSaved);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") long id) {
        UserDTO userDTO = userService.findByID(id);
        return ResponseEntity.ok(userDTO);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") long id) {
        UserDTO userDTO = userService.findByID(id);
        userService.deleteUser(id);
        return ResponseEntity.ok(userDTO);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") long id, @RequestBody UserDTO userDTO) {
       UserDTO updateUser = userService.updateUser(id,userDTO);
       return ResponseEntity.ok(updateUser);
    }

//    Bài 2:
//    từ api lấy danh sách user, sửa api đó thành api cho phép tìm kiếm user theo các tiêu chí sau
// - username hoặc full_name , truyền dữ liệu theo kiểu param
// - gợi ý: join với bảng identity_cards để tìm kiếm theo ful name, sử dụng entity để join

}
