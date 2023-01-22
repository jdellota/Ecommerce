package com.example.Ecommerce.Controller;

import com.example.Ecommerce.DTO.OrderDto;
import com.example.Ecommerce.DTO.ProductDto;
import com.example.Ecommerce.Entity.OrderEntity;
import com.example.Ecommerce.Entity.ProductEntity;
import com.example.Ecommerce.Entity.UserEntity;
import com.example.Ecommerce.RestController.OrderController;
import com.example.Ecommerce.RestController.ProductController;
import com.example.Ecommerce.RestController.UserController;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
public class UserView {
    @Autowired
    private UserController userController;
    @Autowired
    private ProductController productController;
    @Autowired
    private OrderController orderController;


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
        userController.addUser(user);
        return "index";
    }

    //after login
    @GetMapping("/home")

    public String checkUser(@CurrentSecurityContext(expression = "authentication")
                       Authentication authentication, Model model){
        UserEntity user=userController.finduser(authentication.getName());
        if(user.getRole().equals("SELLER")) {
            //get current logged in user

            model.addAttribute("products", user.getProducts());
            return "seller/index";
        }
        else if (user.getRole().equals("CUSTOMER")) {
            //Go to customer index and show all products
            model.addAttribute("products",productController.viewProducts());
            Set<OrderEntity> orders= user.getOrders();
            float total = 0;
            for (OrderEntity order:orders) {
                total += order.getQty() * order.getProductEntity().getPrice();
            }
            model.addAttribute("total",total);
            model.addAttribute("user",user);
                return "customer/index";
       }
        return null;

    }

    @GetMapping("/addproductform")
    public String viewProductForm(Model model){
        ProductDto productDto=new ProductDto();
        model.addAttribute("product",productDto);
        return "seller/addproductform";
    }

    @PostMapping("/addproduct")

    public String addProduct(@CurrentSecurityContext(expression = "authentication")
                                 Authentication authentication, @ModelAttribute ProductDto productDto, Model model){
        UserEntity user=userController.finduser(authentication.getName());
        productDto.setUserid(Math.toIntExact(user.getId()));
        productController.addProduct(productDto);
        model.addAttribute("products", user.getProducts());
        return "seller/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@CurrentSecurityContext(expression = "authentication")
                                    Authentication authentication, @PathVariable(value="id") long id, Model model){
        productController.deleteProductById(id);
        UserEntity user=userController.finduser(authentication.getName());
        model.addAttribute("products", user.getProducts());
        return "seller/index";
    }

    @GetMapping("/updateproductform/{id}")

    public String updateProductForm(@PathVariable(value="id") long id, Model model){
        model.addAttribute("product",productController.getProduct(id));
        return"seller/editproductform";
    }

    @PostMapping("updateproduct/{id}")

    public String updateProduct(@CurrentSecurityContext(expression = "authentication")
        Authentication authentication, @PathVariable(value="id") long id, @ModelAttribute ProductEntity productEntity, Model model){
        UserEntity user=userController.finduser(authentication.getName());
        productEntity.setUserEntity(user);
        productController.updateProduct(productEntity);
        model.addAttribute("products", user.getProducts());
        return"seller/index";
    }

    //Customers

    @PostMapping("/viewproduct")
    public String viewProducts(Model model){
        model.addAttribute("products",productController.viewProducts());
        return "customer/index";
    }

    @GetMapping("/addtocartform/{id}")
    public String orderForm(@PathVariable(value="id") long id, Model model){
        ProductEntity productEntity=productController.getProduct(id);
        model.addAttribute("product", productEntity);
        return "customer/addorderform";
    }

    //Code for Add To Cart
    @PostMapping("/addtocart/{id}")
    public String addToCart(@CurrentSecurityContext(expression = "authentication")
                                Authentication authentication, @PathVariable(value="id") long id, @ModelAttribute OrderDto orderDto, Model model){
        orderDto.setProductid(Math.toIntExact(id));
        UserEntity user=userController.finduser(authentication.getName());
        orderDto.setUserid(Math.toIntExact(user.getId()));
        orderController.addOrder(orderDto);
        model.addAttribute("products",productController.viewProducts());
        model.addAttribute("user",user);
        return "customer/index";
    }

    @GetMapping("/deleteorder/{id}")
    public String deleteOrder(@CurrentSecurityContext(expression = "authentication")
                                Authentication authentication, @PathVariable(value="id") long id, Model model){
        orderController.deleteOrder(id);
        UserEntity user=userController.finduser(authentication.getName());

        Set<OrderEntity> orders= user.getOrders();
        float total = 0;
        for (OrderEntity order:orders) {
            total += order.getQty() * order.getProductEntity().getPrice();
        }
        model.addAttribute("total",total);

        model.addAttribute("products",productController.viewProducts());
        model.addAttribute("user",user);
        return "customer/index";
    }

    @GetMapping("/updateorderform/{id}")

    public String editOrderForm(@PathVariable(value = "id") long id, Model model)
    {
        model.addAttribute("order",orderController.getOrder(id));
        return "/customer/editorderform";
    }

    @PostMapping("/updateorder/{id}")

    public String updateOrder(@CurrentSecurityContext(expression = "authentication")
                               Authentication authentication,@PathVariable(value="id") long id, @ModelAttribute OrderDto orderDto, Model model)
    {
        UserEntity user = userController.finduser(authentication.getName());
        OrderEntity orderEntity = orderController.getOrder(id);
        orderEntity.setUserEntity(user);
        orderEntity.setProductEntity(productController.getProduct(orderDto.getProductid()));
        orderEntity.setQty(orderDto.getQty());
        orderController.updateOrder(orderEntity);
        Set<OrderEntity> orders= user.getOrders();
        float total = 0;
        for (OrderEntity order:orders) {
            total += order.getQty() * order.getProductEntity().getPrice();
        }
        model.addAttribute("total",total);
        model.addAttribute("order",user.getOrders());
        model.addAttribute("products",productController.viewProducts());
        model.addAttribute("user",user);
        return "customer/index";

    }



}
