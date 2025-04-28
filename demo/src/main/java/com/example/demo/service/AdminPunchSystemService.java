package com.example.demo.service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CheckPunch;
import com.example.demo.repository.CheckPunchRepository;

@Service
public class AdminPunchSystemService {
    @Autowired
    private CheckPunchRepository ckRepository;

    public List<CheckPunch> search(String name){            
        return ckRepository.findByName(name);
    }

    public String delete(String id) {
        try {
            Integer parsedId = Integer.parseInt(id);
            Optional<CheckPunch> optional = ckRepository.findById(parsedId);
    
            if (optional.isPresent()) {
                ckRepository.delete(optional.get());
                return "success";
            } else {
                return "not_found";
            }
        } catch (NumberFormatException e) {
            return "invalid_id";
        } catch (Exception e) {
            return "error";
        }
    }

    public void update(CheckPunch checkPunch){
        try {
            Optional<CheckPunch> optional = ckRepository.findById(checkPunch.getId());
            if(optional.isPresent()){
                optional.get().setName(checkPunch.getName());
                optional.get().setLocation(checkPunch.getLocation());
                optional.get().setCheckTime(checkPunch.getCheckTime());
                ckRepository.save(optional.get());
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
