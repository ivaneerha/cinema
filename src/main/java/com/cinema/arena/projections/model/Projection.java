package com.cinema.arena.projections.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;

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
}
