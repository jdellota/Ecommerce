package com.example.Ecommerce.RestController;

import ch.qos.logback.core.model.Model;
import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    //Add the User Registration
    @PostMapping(path = "/adduser")
    public UserEntity addUser(UserEntity user){
        return userService.addUser(user);
    }

}
