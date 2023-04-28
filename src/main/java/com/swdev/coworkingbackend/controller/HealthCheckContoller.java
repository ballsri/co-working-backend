package com.swdev.coworkingbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/healthcheck")
public class HealthCheckContoller {

    @GetMapping("/")
    public String ping(){
        return String.format("the server is up and responding to ping");
    }
}
