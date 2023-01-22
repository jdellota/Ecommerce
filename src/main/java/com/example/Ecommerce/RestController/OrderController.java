package com.example.Ecommerce.RestController;

import com.example.Ecommerce.DTO.OrderDto;
import com.example.Ecommerce.Entity.OrderEntity;
import com.example.Ecommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderapi")
public class OrderController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/addorder")
    public OrderEntity addOrder(OrderDto orderDto){
        return customerService.addOrder(orderDto);
    }

}
