package vn.com.t3h.dao;

import java.util.List;
import vn.com.t3h.model.Product;

public interface ProductDao {
    List<Product> findAll();
    int add(Product product);
    Product getProductById(int id);
}
