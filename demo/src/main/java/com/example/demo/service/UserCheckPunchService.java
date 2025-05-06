package com.example.demo.service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CheckPunch;
import com.example.demo.repository.CheckPunchRepository;

@Service
public class UserCheckPunchService {

    @Autowired
    private CheckPunchRepository ckRepository;
    

    public String punchIn(Principal principal) {
        CheckPunch checkPunch = new CheckPunch();   
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatted = now.format(formatter);             
        String username = principal.getName();
        checkPunch.setName(username);
        checkPunch.setCheckTime(formatted);
        checkPunch.setLocation("地球");
        try {
            ckRepository.save(checkPunch);    
        } catch (Exception e) {
            return "error";
        }
        
        return "success";
    }

    public String punchOut(Principal principal) {
        CheckPunch checkPunch = new CheckPunch();   
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatted = now.format(formatter);             
        String username = principal.getName();
        checkPunch.setName(username);
        checkPunch.setCheckTime(formatted);
        checkPunch.setLocation("地球");
        try {
            ckRepository.save(checkPunch);    
        } catch (Exception e) {
            return "error";
        }
        
        return "success";
    }

    public List<CheckPunch> getHistory(Principal principal){
        List<CheckPunch> checkPunchList = new ArrayList<CheckPunch>();
        checkPunchList = ckRepository.findByName(principal.getName());
        return checkPunchList;
    }
}
