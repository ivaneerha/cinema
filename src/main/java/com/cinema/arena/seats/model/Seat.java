package com.cinema.arena.seats.model;
import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

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
}
