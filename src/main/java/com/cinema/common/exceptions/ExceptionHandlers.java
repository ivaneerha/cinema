package com.cinema.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public abstract class ExceptionHandlers {

    @org.springframework.web.bind.annotation.ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMessage notLoggedIn(Exception e) {
        ErrorMessage msg = new ErrorMessage(e.getMessage(), HttpStatus.UNAUTHORIZED.value(), LocalDateTime.now());
        return msg;
    }

}
