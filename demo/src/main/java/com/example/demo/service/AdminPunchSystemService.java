package com.example.demo.service;


import java.util.List;

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

    public void delete(Integer id){
        ckRepository.delete(ckRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("找不到資料")));
    }
}
