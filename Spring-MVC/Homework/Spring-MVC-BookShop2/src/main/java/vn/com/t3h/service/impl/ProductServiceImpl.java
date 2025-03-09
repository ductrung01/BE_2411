package vn.com.t3h.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.ProductRepository;
import vn.com.t3h.entity.ProductEntity;
import vn.com.t3h.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    @Qualifier("productHibernateRepositoryImpl")
    private ProductRepository productRepository;


    @Override
    public List<ProductEntity> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductEntity> findByCondition(Double price, String bookTitle, String publisher, String categoryName) {
        return productRepository.findByCondition(price, bookTitle, publisher, categoryName);
    }
}
