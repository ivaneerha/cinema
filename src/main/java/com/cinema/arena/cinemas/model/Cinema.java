package com.cinema.arena.cinemas.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@Entity
public class Cinema {

    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    @OneToMany(fetch = FetchType.EAGER)
    private List<Object> projections;
}
