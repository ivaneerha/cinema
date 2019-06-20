package com.cinema.arena.Helper;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor

public class ErrorMessage {

    private String message;
    private int status;
    private LocalDateTime time;

}
