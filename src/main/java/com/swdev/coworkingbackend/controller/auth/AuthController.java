package com.swdev.coworkingbackend.controller.auth;

import com.swdev.coworkingbackend.dto.auth.loginDto;
import com.swdev.coworkingbackend.dto.responseDto;
import com.swdev.coworkingbackend.model.User;
import com.swdev.coworkingbackend.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @PostMapping(value= "/login", consumes = "application/json", produces = "application/json")
    public @ResponseBody responseDto login(@RequestBody loginDto loginDto, HttpServletResponse response){

        String token = authService.login(loginDto);

        if(token == null){
            return new responseDto(false, "login failed", null);
        }

        Map<String, String> data = new HashMap<>();
        data.put("token",token);

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 1); // 1 hour
        
        response.addCookie(cookie);

        return new responseDto(true, "login successfully",data);
    }

    @GetMapping("/logout")
    public @ResponseBody responseDto logout(HttpServletResponse response){
        // remove cookie
        Cookie cookie = new Cookie("token", null);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(0); // 0 hour

        response.addCookie(cookie);

        return new responseDto(true, "logout successfully", null);
    }

    @PostMapping("/register")
    public String register(){
        return String.format("register successfully");
    }
}
