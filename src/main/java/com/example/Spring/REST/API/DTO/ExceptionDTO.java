package com.example.Spring.REST.API.DTO;

import java.time.LocalDateTime;

public class ExceptionDTO {

    public ExceptionDTO() {
    }

    public ExceptionDTO(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }

    private String message;
    private LocalDateTime localDateTime;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
