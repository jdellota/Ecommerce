package com.example.Ecommerce.Service;

import com.example.Ecommerce.DTO.OrderDto;
import com.example.Ecommerce.Entity.OrderEntity;
import com.example.Ecommerce.Entity.ProductEntity;
import com.example.Ecommerce.Repository.OrderRepository;
import com.example.Ecommerce.Repository.ProductRepository;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        orderEntity.setQty(orderDto.getQty());
        orderEntity.setUserEntity(userRepository.getReferenceById((long) orderDto.getUserid()));
        orderEntity.setProductEntity(productRepository.getReferenceById((long) orderDto.getProductid()));
        return orderRepository.save(orderEntity);
    }
    public List<ProductEntity> viewProducts(long id){
        List<ProductEntity> products=productRepository.findAll();
        List<OrderEntity> userOrders = userRepository.getReferenceById(id).getOrders();

        for (OrderEntity order:userOrders
             ) {
            products.remove(order.getProductEntity());
        }
        return products;
    }

    public OrderEntity deleteOrder(long id) {
        return orderRepository.deleteById(id);
    }

    public OrderEntity getOrder(long id) {
        return orderRepository.getReferenceById(id);
    }

    public OrderEntity updateOrder(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }
}
