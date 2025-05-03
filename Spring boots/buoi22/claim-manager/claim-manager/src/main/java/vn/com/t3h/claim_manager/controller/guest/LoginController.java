package vn.com.t3h.claim_manager.controller.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.t3h.claim_manager.service.LoginService;

@Controller
public class LoginController {
  @Autowired
  private LoginService loginService;
  @GetMapping("/login")
  public String login() {
    return "guest/login";
  }
  @GetMapping("/process-after-login-susscess")
  public String processAfterLoginSusscess() {
    return loginService.processAfterLoginSuccess();
  }
}
