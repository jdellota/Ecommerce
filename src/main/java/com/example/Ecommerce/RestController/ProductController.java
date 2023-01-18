package com.example.Ecommerce.RestController;

import com.example.Ecommerce.Entity.ProductEntity;
import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productapi")
public class ProductController {
    @Autowired
    private SellerService sellerService;
    @PostMapping(path = "/addproduct")
    public ProductEntity addProduct(ProductEntity product){
        //product;
        return sellerService.addProduct(product);

    }
}
