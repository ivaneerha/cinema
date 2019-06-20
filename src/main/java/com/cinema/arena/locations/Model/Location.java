package com.cinema.arena.locations.Model;

import com.cinema.arena.cinemas.model.Cinema;
import com.cinema.arena.users.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @UniqueElements
    private String city;

    @NonNull
    @UniqueElements
    private String address;

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private User user;

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Cinema cinema;

}
