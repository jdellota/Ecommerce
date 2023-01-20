package com.example.Ecommerce.Controller;

import com.example.Ecommerce.RestController.ProductController;
import com.example.Ecommerce.RestController.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerView {
    @Autowired
    private ProductController productController;
    @GetMapping("/addproduct")
    public String addProduct(Model model){

        return "/seller/index";
    }

//    @GetMapping("/showaddtask")
//    public String addTask(Model model){
//
//        //Adding Customer goes here.
//        TaskEntity taskEntity = new TaskEntity();
//        model.addAttribute("tasks", taskEntity);
//        return "showaddtask";
//    }
}
