package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.CheckPunch;
import com.example.demo.service.UserCheckPunchService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





@Controller
@RequestMapping("/user/userdashboard")
public class UserCheckPunchController {
    @Autowired
    private UserCheckPunchService userCheckPunchService;

    @GetMapping
    public String userPage(Principal principal,Model model){
        model.addAttribute("userName", principal.getName());
        return "user_dashboard";
    }


    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @PostMapping("/punchIn")
    public String punchIn(Principal principal,RedirectAttributes redirectAttributes) {
        String message = userCheckPunchService.punchIn(principal);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/user/userdashboard";
    }
    @PostMapping("/punchOut")
    public String punchOut(Principal principal,RedirectAttributes redirectAttributes) {
        String message = userCheckPunchService.punchOut(principal);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/user/userdashboard";
    }
    @GetMapping("/punch/history")
    public String getHistory(Principal principal,Model model) {
        List<CheckPunch> checkPunchList = new ArrayList<CheckPunch>();
        checkPunchList = userCheckPunchService.getHistory(principal);
        model.addAttribute("history", checkPunchList);
        return "user_punch_check";
    }
    

}
