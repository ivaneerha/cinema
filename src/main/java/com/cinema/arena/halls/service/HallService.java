package com.cinema.arena.halls.service;

import com.cinema.arena.halls.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;
}
