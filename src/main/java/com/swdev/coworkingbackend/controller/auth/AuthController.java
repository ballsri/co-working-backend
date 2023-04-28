package com.swdev.coworkingbackend.controller.auth;

import com.swdev.coworkingbackend.dto.auth.loginDto;
import com.swdev.coworkingbackend.dto.responseDto;
import com.swdev.coworkingbackend.model.User;
import com.swdev.coworkingbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @PostMapping(value= "/login", consumes = "application/json", produces = "application/json")
    public @ResponseBody responseDto login(@RequestBody loginDto loginDto){

        User user = authService.login(loginDto);

        if(user == null){
            return new responseDto(false, "login failed", null);
        }

        return new responseDto(true, "login successfully", user);
    }

    @PostMapping("/register")
    public String register(){
        return String.format("register successfully");
    }
}
