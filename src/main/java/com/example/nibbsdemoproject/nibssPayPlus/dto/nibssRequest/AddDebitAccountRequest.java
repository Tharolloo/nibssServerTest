package com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class AddDebitAccountRequest {
    @JsonProperty("accounts")
    private List<Account> account;
    private String client_id;
    private String client_secret;
    private String scope;
    private String grant_type;

}
