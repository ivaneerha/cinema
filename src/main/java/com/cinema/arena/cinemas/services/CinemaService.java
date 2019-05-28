package com.cinema.arena.cinemas.services;

import com.cinema.arena.cinemas.model.Cinema;
import com.cinema.arena.cinemas.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public Cinema getCinemaById(String id){
        Optional<Cinema> cinema = cinemaRepository.findById(id);

        if (cinema.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return cinema.get();
    }
}
