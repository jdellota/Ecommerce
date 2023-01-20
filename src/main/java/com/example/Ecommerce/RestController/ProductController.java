package com.example.Ecommerce.RestController;

import com.example.Ecommerce.DTO.ProductDto;
import com.example.Ecommerce.Entity.ProductEntity;
import com.example.Ecommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}
