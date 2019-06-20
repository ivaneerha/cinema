package com.cinema.arena.tickets.model;
import com.cinema.arena.projections.model.Projection;
import com.cinema.arena.seats.model.Seat;
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
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private int price;

    @NonNull
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "ticket_seats",
            joinColumns = {@JoinColumn(name = "ticket_id")},
            inverseJoinColumns = {@JoinColumn(name = "seat_id")}
    )
    Set<Seat> seats = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="projection_id", nullable=false)
    private Projection projection;
}
