package com.example.Ecommerce.Service;

import com.example.Ecommerce.DTO.OrderDto;
import com.example.Ecommerce.Entity.OrderEntity;
import com.example.Ecommerce.Entity.ProductEntity;
import com.example.Ecommerce.Repository.OrderRepository;
import com.example.Ecommerce.Repository.ProductRepository;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    public OrderEntity addOrder(OrderDto orderDto){
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setAmount(orderDto.getAmount());
        orderEntity.setUserEntity(userRepository.getReferenceById((long) orderDto.getUserid()));
        orderEntity.setProductEntity(productRepository.getReferenceById((long) orderDto.getProductid()));
        return orderRepository.save(orderEntity);
    }
}
