package com.cinema.arena.halls.controller;

import com.cinema.arena.halls.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HallController {

    @Autowired
    private HallService hallService;
}
