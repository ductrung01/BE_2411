package vn.com.t3h.controller.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.service.ProductService;
/**
 Bài tập 1:
 viết api lấy danh sách các thông tin của user với các yêu cầu
 url: localhost:8080/api/users
 method: GET
 công nghệ sử dụng:
 hibernate, hql, entity user
 Bài 2:
 từ api lấy danh sách user, sửa api đó thành api cho phép tìm kiếm user theo các tiêu chí sau
 - username hoặc full_name , truyền dữ liệu theo kiểu param
 - gợi ý: join với bảng identity_cards để tìm kiếm theo ful name, sử dụng entity để join

 */
@RestController
@RequestMapping("/api/products")
public class ProductResource {
    @Autowired
    private ProductService productService;
    @GetMapping("/search")
    public ResponseEntity<List<ProductEntity>> search(@RequestParam(required = false , name = "price") Double price,
                                                      @RequestParam(required = false , name = "price") String bookTitle,
                                                      @RequestParam(required = false , name = "price") String publisher,
                                                      @RequestParam(required = false , name = "price") String categoryName) {
        List<ProductEntity> productEntities = productService.findByCondition(price, bookTitle, publisher, categoryName);
        return ResponseEntity.ok(productEntities);
        /*
        200 OK: Thực hiện thành công.
        201 Created: Tạo tài nguyên thành công.
        400 Bad Request: Yêu cầu không hợp lệ.
        404 Not Found: Không tìm thấy tài nguyên.
        500 Internal Server Error: Lỗi từ server.

        */
    }


}
