package com.cinema.arena.projections.model;

import com.cinema.arena.cinemas.model.Cinema;
import com.cinema.arena.movies.model.Movie;
import com.cinema.arena.tickets.model.Ticket;
import com.cinema.arena.users.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "projections")
public class Projection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private LocalDateTime startTime;

    @NonNull
    private LocalDateTime endTime;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "cinema_projections",
            joinColumns = {@JoinColumn(name = "projection_id")},
            inverseJoinColumns = {@JoinColumn(name = "cinema_id")}
    )
    Set<Cinema> cinemas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    private Movie movie;

    @OneToMany(mappedBy="projection")
    private Set<Ticket> tickets;
}
