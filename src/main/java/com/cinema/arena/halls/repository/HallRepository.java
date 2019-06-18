package com.cinema.arena.halls.repository;

import com.cinema.arena.halls.model.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallRepository extends CrudRepository<Hall, Long> {

}
