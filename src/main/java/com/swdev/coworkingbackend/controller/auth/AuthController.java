package com.swdev.coworkingbackend.controller.auth;

import com.swdev.coworkingbackend.dto.auth.loginDto;
import com.swdev.coworkingbackend.dto.auth.registerDto;
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
    public @ResponseBody responseDto register(@RequestBody registerDto registerDto){
        // TODO: 28/4/2023 AD implement register :NATTS
        List<String> errors = authService.register(registerDto);
        if(!errors.isEmpty()){
            return new responseDto(false, "register failed", errors);
        }
        return new responseDto(true, "register successfully", null);
    }
}
