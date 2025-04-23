package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

@Service
public class RegisterService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public String registerUser(Users user){
        Users newUser = new Users();
        newUser.setUserName(user.getUserName());
        String encodedPassword = passwordEncoder.encode(user.getPassWord());
        newUser.setPassWord(encodedPassword);
        newUser.setRole(user.getRole());
        try {
            usersRepository.save(newUser);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }
}
