package com.example.demo.config;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
                                        throws IOException, ServletException {
        // 取得目前登入者的角色
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        String redirectURL = "/home"; // 預設頁面

        for (GrantedAuthority auth : authorities) {
            if (auth.getAuthority().equals("ROLE_ADMIN")) {
                redirectURL = "/admin/dashboard";
                break;
            } else if (auth.getAuthority().equals("ROLE_USER")) {
                redirectURL = "/user/userdashboard";
            }
        }

        response.sendRedirect(redirectURL);
    }


}

