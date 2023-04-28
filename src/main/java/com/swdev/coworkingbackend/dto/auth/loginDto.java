package com.swdev.coworkingbackend.dto.auth;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class loginDto {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    public loginDto() {
    }

    public loginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "loginDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
