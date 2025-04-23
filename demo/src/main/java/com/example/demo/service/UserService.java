package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;

public class UserService implements UserDetailsService{
    private UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("使用者不存在"));

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassWord(),
                List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
