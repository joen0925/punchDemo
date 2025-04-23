package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController{

    @RequestMapping("/error")
    public String handleError() {
        // 返回自定義的錯誤頁面
        return "error"; 
    }
}