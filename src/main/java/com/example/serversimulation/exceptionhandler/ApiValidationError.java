package com.example.serversimulation.exceptionhandler;

import org.springframework.http.HttpStatus;

public class ApiValidationError extends ApiSubError {

    private String object;
    private String field;
    private Object rejectedValue;
    private String message;
    private HttpStatus httpStatus;
    public ApiValidationError() {
    }


    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
