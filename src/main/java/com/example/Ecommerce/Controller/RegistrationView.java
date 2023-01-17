package com.example.Ecommerce.Controller;


import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.RestController.UserController;
import com.example.Ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class RegistrationView {
    @Autowired
    private UserController restController;
    @GetMapping("/registration")
    public String viewRegistration()
    {
        return"/home/registration";
    }

    @GetMapping("/index")
    public String viewHome(){
        return "/home/index";
    }

    @PostMapping(path = "/adduser")
    public String addUser(@ModelAttribute("user") UserEntity user){
        restController.addUser(user);
        return "/home/index";
    }

//    public String addUser(Model model){
//        UserEntity userEntity = new UserEntity();
//        model.addAttribute("user", userEntity);
//        userService.addUser(userEntity);
//        return "/home/index";
//    }
}
