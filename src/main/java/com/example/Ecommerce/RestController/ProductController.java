package com.example.Ecommerce.RestController;

import com.example.Ecommerce.DTO.ProductDto;
import com.example.Ecommerce.Entity.ProductEntity;

import com.example.Ecommerce.Service.CustomerService;
import com.example.Ecommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productapi")
public class ProductController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private CustomerService customerService;
    @PostMapping(path = "/addproduct")
    public ProductEntity addProduct( ProductDto productDTO){
        return sellerService.addProduct(productDTO);
        //return  productDTO;
    }

    @PostMapping(path="/viewproduct/{id}")
    public List<ProductEntity> viewProducts(@PathVariable long id){
        return customerService.viewProducts(id);
    }

    @DeleteMapping(path="/delete/{id}")
    public ProductEntity deleteProductById(@PathVariable long id){
        return sellerService.deleteProductById(id);
    }

    public ProductEntity getProduct(long id) {
        return sellerService.getProduct(id);
    }

    public ProductEntity updateProduct(ProductEntity productEntity) {
        return sellerService.updateProduct(productEntity);
    }
}
