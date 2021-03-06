package com.cinema.arena.users.userDtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserLoginDto {

    @NonNull
    private String username;

    @NonNull
    private String password;
}
