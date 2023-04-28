package com.swdev.coworkingbackend.controller.auth;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/auth")
public class AuthController {
    @PostMapping("/login")
    public String login(){
        return String.format("login successfully");
    }

    @PostMapping("/register")
    public String register(){
        return String.format("register successfully");
    }
}
