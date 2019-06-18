package com.cinema.arena.cinemas.controller;

import com.cinema.arena.cinemas.model.Cinema;
import com.cinema.arena.cinemas.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("{id}")
    public Cinema getCinema(@PathVariable("id") Long id) {
        return cinemaService.getCinemaById(id);
    }
}
