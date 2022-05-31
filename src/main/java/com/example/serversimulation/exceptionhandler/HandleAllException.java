package com.example.serversimulation.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class HandleAllException extends RuntimeException{
    public HandleAllException(String message) {
        super(message);
    }
}
