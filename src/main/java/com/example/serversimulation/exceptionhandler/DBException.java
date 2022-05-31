package com.example.serversimulation.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class DBException extends RuntimeException {
    public DBException(String message) {
        super(message);
    }

}
