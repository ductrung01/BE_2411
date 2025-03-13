package vn.com.t3h.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.service.UserService;
import java.util.List;
@Controller
@RestController("/api")
public class UserResource {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> userEntities = userService.getAllUser();
        if (userEntities.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        System.out.println("getAllUsers: " + userEntities);
        return ResponseEntity.ok(userEntities);
    }
//    @GetMapping("api/users-search")
//    public ResponseEntity<List<UserEntity>> searchUser(@RequestParam(required = false ,name = "userName") String userName,
//                                                       @RequestParam(required = false, name = "fullName") String fullName){
//        List<UserEntity> userEntities = userService.searchUserByName(userName,fullName,i);
//        if(userEntities.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok(userEntities);
//
//    }
//    Bài 2:
//    từ api lấy danh sách user, sửa api đó thành api cho phép tìm kiếm user theo các tiêu chí sau
// - username hoặc full_name , truyền dữ liệu theo kiểu param
// - gợi ý: join với bảng identity_cards để tìm kiếm theo ful name, sử dụng entity để join

}
