package com.cinema.arena.Helper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public abstract class BaseService {

    @ExceptionHandler({ IllegalArgumentException.class })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessage NotLoggedIn(Exception e) {
        ErrorMessage msg = new ErrorMessage(e.getMessage(), HttpStatus.UNAUTHORIZED.value(), LocalDateTime.now());
        return msg;
    }




}
