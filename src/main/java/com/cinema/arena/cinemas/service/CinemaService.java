package com.cinema.arena.cinemas.service;

import com.cinema.arena.cinemas.model.Cinema;
import com.cinema.arena.cinemas.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public Cinema getCinemaById(Long id){
        Optional<Cinema> cinema = cinemaRepository.findById(id);

        if (cinema.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return cinema.get();
    }
}
