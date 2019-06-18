package com.cinema.arena.cinemas.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "cinemas")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cinemaId;

    @NonNull
    private String name;
    @NonNull
    private String contact;


//    @NotNull
//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Object> projections;
}
