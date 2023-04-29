package com.swdev.coworkingbackend.service;

import com.swdev.coworkingbackend.dto.auth.loginDto;
import com.swdev.coworkingbackend.model.User;
import com.swdev.coworkingbackend.repository.AuthRepository;
import com.swdev.coworkingbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public  String login(loginDto loginDto){
        // find if user exist
        User user = authRepository.findByEmail(loginDto.getEmail());
        if(user == null){
            return null;
        }

        // check if password is correct
        if(!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
            return null;
        }

        // generate token from user
        Map<String, String> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        claims.put("name", user.getName());
        claims.put("role", user.getRole());
        return jwtUtil.generateToken( user.getEmail(), claims);
    }

    public String register(){
        return String.format("register successfully");
    }
}
