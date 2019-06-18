package com.cinema.arena.locations.Repository;

import com.cinema.arena.locations.Model.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
}
