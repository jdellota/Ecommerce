package com.example.Ecommerce.Service;

import com.example.Ecommerce.DTO.ProductDto;
import com.example.Ecommerce.Entity.ProductEntity;
import com.example.Ecommerce.Repository.ProductRepository;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    public ProductEntity addProduct(ProductDto productDto) {
        ProductEntity productEntity=new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setUserEntity(userRepository.getReferenceById((long) productDto.getUserid()));
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> viewAllProducts(){
        return productRepository.findAll();
    }
    public ProductEntity deleteProductById(long id){
        return productRepository.deleteById(id);
    }

    public ProductEntity getProduct(long id) {
        return productRepository.getReferenceById(id);
    }

    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }
}
