package com.swdev.coworkingbackend.controller.coworking.room;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coworking/{coworkingId}/room")
public class RoomController {
    @GetMapping("/")
    public String getAllCoWorkingRooms(@PathVariable String coworkingId){
        return String.format("all coworking %s rooms", coworkingId);
    }
}
