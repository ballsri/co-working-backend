package com.swdev.coworkingbackend.service;

import com.swdev.coworkingbackend.dto.auth.loginDto;
import com.swdev.coworkingbackend.dto.auth.registerDto;
import com.swdev.coworkingbackend.model.User;
import com.swdev.coworkingbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.swdev.coworkingbackend.util.PasswordValidator.validatePassword;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    public  User login(loginDto loginDto){
        // find if user exist
        User user = userRepository.findByEmail(loginDto.getEmail());
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

    public List<String> register(registerDto registerDto){
        // initialize errors
        List<String> errors = new ArrayList<String>();

        // check for duplicate email
        User user = userRepository.findByEmail(registerDto.getEmail());
        if(user != null){
            errors.add("email already exist");
        }

        // validate password
        List<String> passwordErrors = validatePassword(registerDto.getPassword());
        if(!passwordErrors.isEmpty()){
            errors.addAll(passwordErrors);
            return errors;
        }

        // validate role
        if(!registerDto.getRole().equals("user") && !registerDto.getRole().equals("admin")){
            errors.add("invalid role");
            return errors;
        }

        // create new user
        User newUser = new User(registerDto.getName(),
                                registerDto.getEmail(),
                                registerDto.getPassword(),
                                registerDto.getPhone(),
                                registerDto.getRole());
        try{
            userRepository.save(newUser);
        }catch (DataAccessException e){
            // log error
            System.out.println("Error creating user"+e.getMessage());
            errors.add("failed to save user");
            return errors;
        }catch (Exception e){
            // log error
            System.out.println("Error creating user"+e.getMessage());
            errors.add("failed to save user with unknown error");
            return errors;
        }
        return errors;
    }
}
