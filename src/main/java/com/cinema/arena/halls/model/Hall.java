package com.cinema.arena.halls.model;

import com.cinema.arena.cinemas.model.Cinema;
import com.cinema.arena.seats.model.Seat;
import com.cinema.arena.tickets.model.Ticket;
import com.cinema.arena.users.model.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "halls")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String type;

    @OneToMany(mappedBy="hall")
    private Set<Seat> seats;

    @ManyToOne
    @JoinColumn(name="cinema_id", nullable=false)
    private Cinema cinema;

}
