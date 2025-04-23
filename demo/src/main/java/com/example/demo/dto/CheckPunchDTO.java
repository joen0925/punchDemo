package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.model.CheckPunch;

@Component
public class CheckPunchDTO {
    private int status;
    private String message;
    private CheckPunch result;

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public CheckPunch getResult() {
        return result;
    }
    public void setResult(CheckPunch checkPunch) {
        this.result = checkPunch;
    }

    
}
