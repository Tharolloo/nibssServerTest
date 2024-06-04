package com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddDebitAccountResponse {
    @JsonProperty("message")
    private String message;
    @JsonProperty("success")
    private String success;


}
