package com.swdev.coworkingbackend.service;

import com.swdev.coworkingbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReservationService {
    @Autowired
    private UserRepository userRepository;



}
