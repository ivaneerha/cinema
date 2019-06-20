package com.cinema.arena.users.model;

import com.cinema.arena.locations.Model.Location;
import com.cinema.arena.tickets.model.Ticket;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @UniqueElements
    private String gsm;

    @NonNull
    private String password;

    @NonNull
    @UniqueElements
    private String email;

    @NonNull
    @UniqueElements
    private String username;

    private String favouriteMovie;

    private String favouriteActor;

    @NonNull
    private boolean isAdmin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy="user")
    private Set<Ticket> tickets;

}
