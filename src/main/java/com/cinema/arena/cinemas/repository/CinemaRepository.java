package com.cinema.arena.cinemas.repository;

import com.cinema.arena.cinemas.model.Cinema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Long> {

    @Query(value = "select * from cinemas where name=#{name}", nativeQuery = true)
    public Cinema findByName(@Param("name") String name);
}
