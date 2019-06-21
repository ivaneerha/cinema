package com.cinema.arena.cinemas.cinemaDtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class AddCinemaDto {

    @NonNull
    private String name;
    @NonNull
    private String contact;
    @NonNull
    private String city;
    @NonNull
    private String address;

}
