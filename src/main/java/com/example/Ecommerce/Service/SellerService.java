package com.example.Ecommerce.Service;

import com.example.Ecommerce.DTO.ProductDTO;
import com.example.Ecommerce.Entity.ProductEntity;
import com.example.Ecommerce.Repository.ProductRepository;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    public String addProduct(ProductDTO productDTO) {
        ProductEntity productEntity=new ProductEntity(productDTO.getName(),productDTO.getPrice(),
                userRepository.getReferenceById((long) productDTO.getUserid()));

        //productEntity.setUserEntity(userRepository.getReferenceById((long) productDTO.getUserid()));
          productRepository.save(productEntity);
        //return userRepository.getById((long) productDTO.getUserid());
        //return userRepository.getReferenceById();
        //return (long)productDTO.getUserid();
        //return productEntity.getUserEntity();
        return "product saved";
    }
}
