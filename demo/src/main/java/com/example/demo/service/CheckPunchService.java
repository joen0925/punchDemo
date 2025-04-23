package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.CheckPunch;
import com.example.demo.repository.CheckPunchRepository;


@Service
public class CheckPunchService {
    @Autowired
    private CheckPunchRepository ckRepository;
    public void creatCheckPunch(CheckPunch ck){
        ckRepository.save(ck);
    }
    public Optional<CheckPunch> getCheckPunch(int id){
        return ckRepository.findById(id);

    }
    public void updateCheckPunch(int id, CheckPunch ck){
        CheckPunch ckOld = new CheckPunch();
        ckOld = ckRepository.findById(id).get();
        ckOld.setName(ck.getName());
        ckOld.setCheckTime(ck.getCheckTime());
        ckOld.setLocation(ck.getLocation());
        ckRepository.save(ckOld);
    }
    public void delCheckPunch(int id){
        ckRepository.deleteById(id);
    }
}
