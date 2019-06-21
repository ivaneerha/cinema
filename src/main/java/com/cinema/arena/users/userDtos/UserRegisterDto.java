package com.cinema.arena.users.userDtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter

public class UserRegisterDto {
    @NonNull
    private String firstName;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @NonNull
    private String lastName;
    @NonNull
    private String username;


}
