package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.CheckPunchDTO;
import com.example.demo.model.CheckPunch;
import com.example.demo.service.AdminPunchSystemService;

@Controller
@RequestMapping("/admin/punchSystem")
public class AdminPunchSystemController {
    @Autowired
    private AdminPunchSystemService adminPunchSystemService;
    @GetMapping
    public String getPunchSystemPage() {
        return "punch_system";
    }
    
    @GetMapping("/search")
    public String search(@RequestParam String name,Model model) {
        List<CheckPunch> checkPunchList = new ArrayList<CheckPunch>();
        checkPunchList = adminPunchSystemService.search(name);        
        model.addAttribute("records", checkPunchList);
        model.addAttribute("searchName", name);
        return "punch_system";
    }
    

    @GetMapping("/del")
    public String delete(@RequestParam("id") String id,@RequestParam("name") String name,Model model) {
        String message = "";
        message = adminPunchSystemService.delete(id);
        return "redirect:/admin/punchSystem/search?name=" + name;
    }
    
    @PostMapping("/update")
    public String updateCheckPunch(@ModelAttribute CheckPunch checkPunch){
        adminPunchSystemService.update(checkPunch);
        return "redirect:/admin/punchSystem/search?name=" + checkPunch.getName();
    }
}
