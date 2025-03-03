package vn.com.t3h.controller.cms.product.insert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowProductController {
    @GetMapping("/cms/add-product")
    public String addProduct() {
        return "cms/admin-productManager-addProduct";
    }
}
