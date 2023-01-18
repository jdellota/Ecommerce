package com.example.Ecommerce.Service;

import com.example.Ecommerce.Entity.ProductEntity;
import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    ProductRepository productRepository;
    public ProductEntity addProduct(ProductEntity product) {
        //product.setUserEntity(productRepository.findById(product.getId()));
        return productRepository.save(product);
    }
}
