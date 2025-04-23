package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CheckPunchDTO;
import com.example.demo.model.CheckPunch;
import com.example.demo.service.CheckPunchService;


@RestController
@RequestMapping("/admin/checkpunch")
public class AdminCheckPunchAPIController {
    @Autowired
    private CheckPunchService checkPunchService;
    @Autowired
    private CheckPunchDTO ckDtpDto;

    @PostMapping("/")
    public CheckPunchDTO creatCheckPunch(@RequestBody CheckPunch checkPunch) {
        ckDtpDto.setMessage("建立成功");
        ckDtpDto.setStatus(200);
        checkPunchService.creatCheckPunch(checkPunch);//記得新增ID回來讓使用者可以修改
        return ckDtpDto;
    }
    @GetMapping("/{id}")
    public CheckPunchDTO getCheckPunch(@PathVariable int id) {                
        try {
            ckDtpDto.setMessage("查詢成功");
            ckDtpDto.setStatus(200);
            ckDtpDto.setResult(checkPunchService.getCheckPunch(id).get());
        } catch (EmptyResultDataAccessException e) {
            ckDtpDto.setMessage("查詢失敗，為有這個Id值");
            ckDtpDto.setStatus(500);
        }
        
        return ckDtpDto;
    }
    @PutMapping("/{id}")
    public CheckPunchDTO updateCheckPunch(@PathVariable int id,@RequestBody CheckPunch checkPunch){
        ckDtpDto.setResult(null);
        try {
            ckDtpDto.setMessage("更新成功");
            ckDtpDto.setStatus(200);
            checkPunchService.updateCheckPunch(id, checkPunch);
        } catch (EmptyResultDataAccessException e) {
            ckDtpDto.setMessage("更新失敗，未有這個Id值");
            ckDtpDto.setStatus(500);
        }
        
        return ckDtpDto;
    }
    @DeleteMapping("/{id}")
    public CheckPunchDTO delCheckPunch(@PathVariable int id){
        ckDtpDto.setResult(null);  
        try {
            ckDtpDto.setMessage("刪除成功");
            ckDtpDto.setStatus(200);
            checkPunchService.delCheckPunch(id);
        } catch (EmptyResultDataAccessException e) {
            ckDtpDto.setMessage("刪除失敗，未有這個Id值");
            ckDtpDto.setStatus(500);
        }
        return ckDtpDto;
    }
}
