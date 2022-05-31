package com.example.serversimulation.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_chats")
public class Chats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "message")
    private String message;
    @Column(name = "userId")
    private String userId;
    @Column(name = "sentToUserId")
    private String sentToUserId;
    @Column(name = "creationDate")
    private Date creationDate;
    @Column(name = "isSent")
    private Boolean isSent;
    @Column(name = "status")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSentToUserId() {
        return sentToUserId;
    }

    public void setSentToUserId(String sentToUserId) {
        this.sentToUserId = sentToUserId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getSent() {
        return isSent;
    }

    public void setSent(Boolean sent) {
        isSent = sent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Chats(Long id, String message, String userId, String sentToUserId, Date creationDate, Boolean isSent, Integer status) {
        this.id = id;
        this.message = message;
        this.userId = userId;
        this.sentToUserId = sentToUserId;
        this.creationDate = creationDate;
        this.isSent = isSent;
        this.status = status;
    }

    public Chats() {
    }
}
