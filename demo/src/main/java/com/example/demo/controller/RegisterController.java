package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.model.Users;
import com.example.demo.service.RegisterService;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService rService;

    @GetMapping
    public String registerPage() {
        return "register"; 
    }
    @PostMapping("/creat")
    public String  postMethodName(@ModelAttribute Users user,Model model) {        
        try {
            String message = rService.registerUser(user);
            model.addAttribute("message", message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "register";
    }
    

}
