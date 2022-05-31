package com.example.serversimulation.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Component
public class CreateChat {
    @NotBlank(message = "Message Cannot be blank or null")
    private String message;
   // @NotBlank(message = "sent can not be empty or blank")
    private Boolean isSent;
    @NotNull(message = "timestamp can not be empty or blank")
    private Date timestamp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSent() {
        return isSent;
    }

    public void setSent(Boolean sent) {
        isSent = sent;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
