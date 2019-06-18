package com.cinema.arena.halls.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "halls")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cinemaId;

    @NonNull
    private String type;


}
