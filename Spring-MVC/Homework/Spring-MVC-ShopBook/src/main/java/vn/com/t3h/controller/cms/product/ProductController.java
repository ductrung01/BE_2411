package vn.com.t3h.controller.cms.product;


import java.util.List;
import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.t3h.model.Product;
import vn.com.t3h.service.ProductService;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

   @GetMapping("/cms/product")
    public String product(Model model) {
       List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "cms/admin-productManager";
   }
}
