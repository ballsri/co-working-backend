package com.swdev.coworkingbackend.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class responseDto {
    @JsonProperty("success")
    private boolean success;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private Object data;

    public responseDto() {
    }


    public responseDto(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }


}
