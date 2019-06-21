package com.cinema.arena.cinemas.model;

import com.cinema.arena.halls.model.Hall;
import com.cinema.arena.locations.model.Location;
import com.cinema.arena.projections.model.Projection;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "cinemas")
public class Cinema {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;
    @NonNull
    private String contact;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToMany(mappedBy = "cinemas")
    private Set<Projection> projections = new HashSet<>();

    @OneToMany(mappedBy="cinema")
    private Set<Hall> halls;
}
