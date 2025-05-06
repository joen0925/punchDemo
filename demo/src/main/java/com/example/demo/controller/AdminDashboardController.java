package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.UserCheckPunchService;



@Controller
@RequestMapping("/admin/dashboard")
public class AdminDashboardController {    
    @Autowired
    private UserCheckPunchService userCheckPunchService;

    @GetMapping
    public String getAdminDashBoardPage() {
        return "admin_dashboard";
    }
    
    @PostMapping("/punchIn")
    public String punchIn(Principal principal,RedirectAttributes redirectAttributes) {
        String message = userCheckPunchService.punchIn(principal);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/admin/dashboard";
    }
    @PostMapping("/punchOut")
    public String punchOut(Principal principal,RedirectAttributes redirectAttributes) {
        String message = userCheckPunchService.punchOut(principal);
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/admin/dashboard";
    }
    @GetMapping("/punchSystem")
    public String getMethodName() {
        return "redirect:/admin/punchSystem";
    }
    
   
}
