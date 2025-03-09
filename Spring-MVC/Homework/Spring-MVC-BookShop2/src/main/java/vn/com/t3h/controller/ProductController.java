package vn.com.t3h.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.service.ProductService;
import java.util.List;
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("product")
    public String product(Model model) {
    List<ProductEntity> productEntityList = productService.getProduct();
    model.addAttribute("productEntityList", productEntityList);
    return "product";
    }
}
