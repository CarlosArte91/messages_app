package com.ccruz.messages_app.entity;

import java.sql.Timestamp;

/**
 *
 * @author carlos_cruz
 */
public class Message {
    private int idMessage;
    private String message;
    private String author;
    private Timestamp messageDate;
    
    public Message() {}
    
    public Message(int idMessage, String message, String author, Timestamp messageDate) {
        this.idMessage = idMessage;
        this.message = message;
        this.author = author;
        this.messageDate = messageDate;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Timestamp messageDate) {
        this.messageDate = messageDate;
    }

    @Override
    public String toString() {
        return "id: " + idMessage + ", message: " + message + ", author: " + author + ", date: " + messageDate;
    }
}
