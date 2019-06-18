package com.cinema.arena.tickets.model;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;
import java.time.LocalDateTime;

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
}
