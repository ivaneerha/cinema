package com.cinema.arena.cinemas.controller;

import com.cinema.arena.cinemas.model.Cinema;
import com.cinema.arena.cinemas.repository.CinemaRepository;
import com.cinema.arena.cinemas.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("{id}")
    public Cinema getCinema(@PathVariable("id") String id) {
        return cinemaService.getCinemaById(id);
    }
}
