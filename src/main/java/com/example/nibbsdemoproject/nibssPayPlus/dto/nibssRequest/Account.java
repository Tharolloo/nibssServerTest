package com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    @JsonProperty("bankCode")
    private String bankCode;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("commonName")
    private String commonName;
    @JsonProperty("accountName")
    private String accountName;

}
