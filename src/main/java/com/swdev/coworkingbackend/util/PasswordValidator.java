package com.swdev.coworkingbackend.util;

import java.util.ArrayList;
import java.util.List;

public class PasswordValidator {
    public static List<String> validatePassword(String password){
        List<String> errors = new ArrayList<>();
        if(password.length() < 8){
            errors.add("password must be at least 8 characters");
        }
        if(password.length() > 16){
            errors.add("password must be at most 16 characters");
        }
        if(!password.matches(".*[A-Z].*")){
            errors.add("password must contain at least one uppercase letter");
        }
        if(!password.matches(".*[a-z].*")){
            errors.add("password must contain at least one lowercase letter");
        }
        if(!password.matches(".*[0-9].*")){
            errors.add("password must contain at least one number");
        }
        return errors;
    }


}
