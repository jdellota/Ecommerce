package com.example.Ecommerce.Repository;

import com.example.Ecommerce.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <ProductEntity, Long> {

    public ProductEntity deleteById(long id);
}
