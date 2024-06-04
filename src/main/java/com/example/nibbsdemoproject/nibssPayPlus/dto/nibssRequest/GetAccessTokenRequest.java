package com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class GetAccessTokenRequest {
    private String client_id;
    private String client_secret;
    private String scope;
    private String grant_type;
}
