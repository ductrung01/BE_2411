package vn.com.t3h.service;

import java.util.List;
import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.model.ProductDTO;

public interface ProductService {
    List<ProductEntity> getProduct();
    public List<ProductEntity> findByCondition(Double price, String bookTitle, String publisher, String categoryName);
}
