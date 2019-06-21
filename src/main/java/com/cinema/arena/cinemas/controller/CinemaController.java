package com.cinema.arena.cinemas.controller;

import com.cinema.arena.cinemas.cinemaDtos.AddCinemaDto;
import com.cinema.arena.cinemas.model.Cinema;
import com.cinema.arena.cinemas.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinema/{id}")
    public Cinema getCinema(@PathVariable("id") Long id, HttpServletResponse response) {
        return cinemaService.getCinemaById(id, response);
    }

    @PostMapping("/cinema/add")
    public void addCinema(@RequestBody AddCinemaDto cinema, HttpServletRequest request, HttpSession session) {

    }

}
