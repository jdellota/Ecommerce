package com.example.Ecommerce.RestController;

import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    //Add the User Registration
    @PostMapping(path = "/adduser")
    public UserEntity addUser(@RequestParam String email, String password, String role){
        return userService.addUser(email,password,role);
    }

}
