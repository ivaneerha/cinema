package com.cinema.arena.movies.model;
import com.cinema.arena.genres.model.Genre;
import com.cinema.arena.projections.model.Projection;
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
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @UniqueElements
    private String title;

    @ManyToOne
    @JoinColumn(name="genre_id", nullable=false)
    private Genre genre;

    @OneToMany(mappedBy="movie")
    private Set<Projection> projections;
}
