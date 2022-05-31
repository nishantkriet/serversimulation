package com.example.serversimulation.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadReqeustException extends RuntimeException{
    public BadReqeustException(String message) {
        super(message);
    }
}
