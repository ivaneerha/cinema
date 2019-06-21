package com.cinema.arena.cinemas.service;

import com.cinema.arena.cinemas.model.Cinema;
import com.cinema.arena.cinemas.repository.CinemaRepository;
import com.cinema.common.exceptions.ExceptionHandlers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class CinemaService extends ExceptionHandlers {

    public static final String NO_CINEMA_FOUND = "No cinema found!";
    @Autowired
    private CinemaRepository cinemaRepository;

    public Cinema getCinemaById(Long id, HttpServletResponse response) {
        Optional<Cinema> cinema = cinemaRepository.findById(id);

        if (cinema.isEmpty()) {
            throw new IllegalArgumentException(NO_CINEMA_FOUND);
        }

        return cinema.get();
    }
}
