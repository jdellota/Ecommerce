package com.example.Ecommerce.RestController;

import com.example.Ecommerce.DTO.ProductDto;
import com.example.Ecommerce.Entity.ProductEntity;
import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productapi")
public class ProductController {
    @Autowired
    private SellerService sellerService;
    @PostMapping(path = "/addproduct")
    public ProductEntity addProduct( ProductDto productDTO){
        return sellerService.addProduct(productDTO);
        //return  productDTO;
    }

    @PostMapping(path="/viewproduct")
    public List<ProductEntity> viewProducts(){
        return sellerService.viewAllProducts();
    }

    @DeleteMapping(path="/delete/{id}")
    public ProductEntity deleteProductById(@PathVariable long id){
        return sellerService.deleteProductById(id);
    }

    public ProductEntity getProduct(long id) {
        return sellerService.getProduct(id);
    }
}
