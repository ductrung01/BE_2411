package vn.com.t3h.claim_manager.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // khai bao day la 1 controller tra ve view html
@RequestMapping("/cms") // lam goc url cho tat ca  method trong controller
public class DashboardController {
 @GetMapping("/doashboard")
    public String admin() {
     return "cms/doashboard";
 }

}
