package com.cinema.arena.projections.repository;

import com.cinema.arena.projections.model.Projection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectionRepository extends CrudRepository<Projection, Long> {
}
