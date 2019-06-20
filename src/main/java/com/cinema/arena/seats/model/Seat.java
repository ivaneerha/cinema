package com.cinema.arena.seats.model;
import com.cinema.arena.halls.model.Hall;
import com.cinema.arena.projections.model.Projection;
import com.cinema.arena.tickets.model.Ticket;
import com.cinema.arena.users.model.User;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long SeatId;

    private int line;
    private int seat;

    @ManyToMany(mappedBy = "seats")
    private Set<Ticket> tickets = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="hall_id", nullable=false)
    private Hall hall;
}
