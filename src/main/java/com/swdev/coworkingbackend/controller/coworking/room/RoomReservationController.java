package com.swdev.coworkingbackend.controller.coworking.room;

import org.springframework.web.bind.annotation.*;

import java.util.Random;
@RestController
@RequestMapping("/api/v1/coworking/{coworkingId}/room/{roomId}/reservation")
public class RoomReservationController {
    @GetMapping("/")
    public String getAllRoomReservations(@PathVariable String coworkingId, @PathVariable String roomId){
        return String.format("all reservations from room \"%s\" from coworking \"%s'\"", roomId, coworkingId);
    }

    @PostMapping ("/")
    public String createRoomReservation(@PathVariable String coworkingId, @PathVariable String roomId){
        String reservationId = String.format("res-%2d", new Random().nextInt(100));
        return String.format("create reservation named \"%s\" from room \"%s\" from coworking \"%s\"", roomId, coworkingId);
    }

    @PutMapping ("/{reservationId}")
    public String updateRoomReservation(@PathVariable String coworkingId, @PathVariable String roomId, @PathVariable String reservationId){
        return String.format("update reservation \"%s\" from room \"%s\" from coworking \"%s\"", reservationId, roomId, coworkingId);
    }

    @DeleteMapping ("/{reservationId}")
    public String deleteRoomReservation(@PathVariable String coworkingId, @PathVariable String roomId, @PathVariable String reservationId){
        return String.format("delete reservation \"%s\" from room \"%s\" from coworking \"%s\"", reservationId, roomId, coworkingId);
    }
}
