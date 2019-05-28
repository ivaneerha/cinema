package com.cinema.arena.cinemas.repository;

import com.cinema.arena.cinemas.model.Cinema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, String> {

}
