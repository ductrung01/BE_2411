package vn.com.t3h.claim_manager.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@RestController dungf dde danh dau day la lop viet ra api

@Controller
@RequestMapping("/cms")
public class UserManagerController {
    @GetMapping("/user-manager")
    public String userManager() {
        return "cms/user/user-manager";
    }
}
