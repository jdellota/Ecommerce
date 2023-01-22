package com.example.Ecommerce.RestController;

import com.example.Ecommerce.DTO.OrderDto;
import com.example.Ecommerce.Entity.OrderEntity;
import com.example.Ecommerce.Entity.ProductEntity;
import com.example.Ecommerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderapi")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping(path="/viewproduct")
    public List<ProductEntity> viewProducts(){
        return orderService.viewAllProducts();
    }
    @PostMapping("/addorder")
    public OrderEntity addOrder(OrderDto orderDto){
        return orderService.addOrder(orderDto);
    }

}
