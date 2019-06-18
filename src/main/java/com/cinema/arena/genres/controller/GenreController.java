package com.cinema.arena.genres.controller;

import com.cinema.arena.genres.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;
}
