package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.Repository.UserRepository;
import com.example.Ecommerce.RestController.UserController;
import com.example.Ecommerce.Service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
public class UserView {
    @Autowired
    private UserController restController;

    @Autowired
    private UserRepository userRepository;
//    @GetMapping("/registration")
//    public String viewRegistration()
//    {
//        return"register";
//    }


    //Method that returns the index
    @GetMapping("/index")
    public String viewHome(){
        return "index";
    }


    //Method to view the Registration Form
    @GetMapping("/register")

    public String showRegistrationForm(Model model){

        return "register";
    }

    //Method to add the user to database
    @PostMapping(path = "/adduser")
    public String addUser(@ModelAttribute("user") UserEntity user){
        restController.addUser(user);
        return "index";
    }


//    public String listUsers(Model model) {
//        List<UserEntity> listUsers = userRepository.findAll();
//        model.addAttribute("users", listUsers);
//        return "home";
//    }
    @GetMapping("/home")

    public String test(@CurrentSecurityContext(expression = "authentication")
                       Authentication authentication, Model model){

        model.addAttribute("users", authentication.getName());

        return"home";
    }


}
