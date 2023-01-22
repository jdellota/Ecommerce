package com.example.Ecommerce.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderid")
    private Long id;

    @Column(name="qty")
    private int qty;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    private ProductEntity productEntity;
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }


}
