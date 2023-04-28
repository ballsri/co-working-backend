package com.swdev.coworkingbackend.service;

import com.swdev.coworkingbackend.dto.auth.loginDto;
import com.swdev.coworkingbackend.model.User;
import com.swdev.coworkingbackend.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;
    public  User login(loginDto loginDto){
        // find if user exist
        User user = authRepository.findByEmail(loginDto.getEmail());
        if(user == null){
            return null;
        }

        // check if password is correct
        if(!user.getPassword().equals(loginDto.getPassword())){
            return null;
        }

        // return user
        return user;

    }

    public String register(){
        return String.format("register successfully");
    }
}
