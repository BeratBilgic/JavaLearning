package com.example.kafka.dto;

import java.time.LocalDate;
import java.util.UUID;

public class KafkaMessage {
    private String message;
    private String id = UUID.randomUUID().toString();
    private LocalDate messageDate = LocalDate.now();

    public KafkaMessage() {
    }

    public KafkaMessage(String message, String id, LocalDate messageDate) {
        this.message = message;
        this.id = id;
        this.messageDate = messageDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDate messageDate) {
        this.messageDate = messageDate;
    }

    @Override
    public String toString() {
        return "KafkaMessage{" +
                "message='" + message + '\'' +
                ", id='" + id + '\'' +
                ", messageDate=" + messageDate +
                '}';
    }
}
