package com.example.Ecommerce.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class RegistrationView {

    @GetMapping("/registration")
    public String viewRegistration()
    {

        return"/home/registration";
    }

    @GetMapping("/index")
    public String viewHome(){
        return "/home/index";
    }
}
