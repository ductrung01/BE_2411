package vn.com.t3h.service;

import vn.com.t3h.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    int addProduct(Product product);
    Product getProductById(int id);
}
