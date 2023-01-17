package com.example.Ecommerce.Service;

import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity addUser(String email, String password, String role) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setPassword(password);
        userEntity.setRole(role);
        return userRepository.save(userEntity);
    }
}
