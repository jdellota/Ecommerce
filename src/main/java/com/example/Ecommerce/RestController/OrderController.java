package com.example.Ecommerce.RestController;

import com.example.Ecommerce.DTO.OrderDto;
import com.example.Ecommerce.Entity.OrderEntity;
import com.example.Ecommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderapi")
public class OrderController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/addorder")
    public OrderEntity addOrder(OrderDto orderDto){
        return customerService.addOrder(orderDto);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteOrder(@PathVariable long id ) {
        customerService.deleteOrder(id);

    }

    public OrderEntity getOrder(long id) {
        return customerService.getOrder(id);
    }

    public OrderEntity updateOrder(OrderEntity orderEntity) {
        return customerService.updateOrder(orderEntity);
    }
}
