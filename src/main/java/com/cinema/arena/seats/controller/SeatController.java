package com.cinema.arena.seats.controller;

import com.cinema.arena.seats.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {

    @Autowired
    private SeatService seatService;
}
