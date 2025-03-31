package vn.com.t3h.claim_manager.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//@RestController dungf dde danh dau day la lop viet ra api

@Controller
@RequestMapping("/cms")
public class UserManagerController {
    @GetMapping("/user-manager")
    public String userManager() {
        return "cms/user/user-manager";
    }

    @GetMapping("/create-user")
    public String createUser() {
        return "cms/user/create-user";
    }
}
