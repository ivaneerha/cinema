package com.cinema.common.exceptions;

public class InvalidInputDataException extends KinoArenaException {

    private static final long serialVersionUID = 4058838472671315175L;

    public InvalidInputDataException() {
        super("Wrong Input, please try again!");
    }

    public InvalidInputDataException(String text) {
        super(text);
    }
}
