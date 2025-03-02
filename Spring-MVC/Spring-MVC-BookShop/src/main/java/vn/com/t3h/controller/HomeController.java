package vn.com.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
	@Controller : Sẽ giúp trả về dữ liệu dạng html,file view
 */
@Controller
public class HomeController {
    /*
      @GetMapping: Sử dụng phương thức Http get
	   @PostMapping: Sử dụng phương thức Http post
     */
    @GetMapping("/home")
    public String home(Model model) {
//        Tra ve ten file trang-chu.jsp
        return "trang-chu";
    }
}
