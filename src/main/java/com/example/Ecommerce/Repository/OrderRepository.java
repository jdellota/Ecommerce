package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
