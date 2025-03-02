package vn.com.t3h.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.t3h.model.Product;
import vn.com.t3h.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    //    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public String products(Model model) {
        List<Product> products = productService.getProducts();
//        Gson gson = new Gson();
        // convert object java to String json
//        String jsonProjection = gson.toJson(products);
        model.addAttribute("products", products);
        return "/cms/admin-productManager";
    }

}
