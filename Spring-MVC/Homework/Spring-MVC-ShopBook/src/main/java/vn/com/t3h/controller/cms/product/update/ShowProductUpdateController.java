package vn.com.t3h.controller.cms.product.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import vn.com.t3h.model.Product;
import vn.com.t3h.service.ProductService;

@Controller
public class ShowProductUpdateController {
    @Autowired
    private ProductService productService;
    @GetMapping("/cms/update-product/{id}")
/*
@PathVariable được sử dụng để lấy giá trị từ URL của request.

*/
    public String getProductById(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "cms/admin-productManager-updateProduct";
    }
}
