package com.example.Ecommerce.Service;

import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }

    public void saveUser(UserEntity userEntity){
        this.userRepository.save(userEntity);
    }
    public Iterable<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }
}
