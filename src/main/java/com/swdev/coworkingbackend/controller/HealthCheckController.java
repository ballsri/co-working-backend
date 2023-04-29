package com.swdev.coworkingbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/healthcheck")
public class HealthCheckController {

    @GetMapping("/")
    public String ping(){
        return String.format("the server is up and responding to ping");
    }
}
