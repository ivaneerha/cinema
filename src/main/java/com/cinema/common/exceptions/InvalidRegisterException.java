package com.cinema.common.exceptions;

public class InvalidRegisterException extends KinoArenaException {

    private static final long serialVersionUID = 4058838472671315175L;

    public InvalidRegisterException() {
        super("Wrong Input, please try again!");
    }

    public InvalidRegisterException(String text) {
        super(text);
    }
}
