package com.backend.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date currentTime;
    private String message;


    public ExceptionResponse(Date currentTime, String message, String details) {
        this.currentTime = currentTime;
        this.message = message;
        this.details = details;
    }


    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    private String details;







}


