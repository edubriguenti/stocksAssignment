package com.payconiq.stock.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiError {

    public ApiError(String message) {
        this.message = message;
    }

    @JsonProperty("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}