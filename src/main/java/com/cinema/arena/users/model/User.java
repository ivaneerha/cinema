package com.cinema.arena.users.model;
import com.cinema.arena.locations.model.Location;
import com.cinema.arena.tickets.model.Ticket;
import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @Column(unique=true)
    private String gsm;

    @NonNull
    private String password;

    @NonNull
    @Column(unique=true)
    private String email;

    @NonNull
    @Column(unique=true)
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
