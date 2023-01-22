package com.example.Ecommerce.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="userid")
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="role")
    private String role;

    @OneToMany(mappedBy = "userEntity")
    private Set<ProductEntity> products;
    @OneToMany(mappedBy = "userEntity")
    private Set<OrderEntity> orders;


    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }



    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
