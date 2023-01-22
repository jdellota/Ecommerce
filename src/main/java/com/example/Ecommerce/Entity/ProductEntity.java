package com.example.Ecommerce.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productid")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private Float price;
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private UserEntity userEntity;
    @OneToMany(mappedBy = "productEntity")
    private Set<OrderEntity> orders;

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }


    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
