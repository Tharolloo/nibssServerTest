package com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class NibssAuthenticationResponse {
    private String access_token;
    private String token_type;
    private String expires_in;
    private String ext_expires_in;
    private int statusCode;
}