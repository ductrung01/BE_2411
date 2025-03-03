package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.ProductDao;
import vn.com.t3h.model.Product;
import vn.com.t3h.service.ProductService;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @Override
    public int addProduct(Product product) {
        return productDao.add(product);
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }


}
