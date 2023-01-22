package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Entity.OrderEntity;
import com.example.Ecommerce.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    public OrderEntity deleteById(long id);
}
