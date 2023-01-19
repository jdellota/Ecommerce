package com.example.Ecommerce.RestController;

import com.example.Ecommerce.DTO.ProductDTO;
import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productapi")
public class ProductController {
    @Autowired
    private SellerService sellerService;
    @PostMapping(path = "/addproduct")
    public @ResponseBody String addProduct(@RequestBody ProductDTO productDTO){
        return sellerService.addProduct(productDTO);
        //return  productDTO;

    }

}
