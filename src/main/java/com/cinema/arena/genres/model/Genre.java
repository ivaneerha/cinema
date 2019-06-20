package com.cinema.arena.genres.model;

import com.cinema.arena.movies.model.Movie;
import com.cinema.arena.tickets.model.Ticket;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @UniqueElements
    private String name;

    @OneToMany(mappedBy="genre")
    private Set<Movie> movies;
}
