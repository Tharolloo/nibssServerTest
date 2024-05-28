package com.example.nibbsdemoproject.utills;

import com.example.nibbsdemoproject.config.AppConfig;
import com.example.nibbsdemoproject.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.dto.nibssResponse.NibssAuthenticationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NibssAuthenticationTest {

    @Autowired
    AppConfig appConfig;



    @Test
    void generateAccessToken() {
        GetAccessTokenRequest accessTokenCredentials = GetAccessTokenRequest
                .builder()
                .client_id("876cca27-6e23-4218-be18-87a1d2d4f195")
                .client_secret("ZyV8Q~WGBjyj2v57GpywxPaHMXNqYEE2A26E5cQ.")
                .scope("876cca27-6e23-4218-be18-87a1d2d4f195/.default")
                .grant_type("client_credentials")
                .build();

        NibssAuthenticationResponse accessToken = NibssAuthentication.generateAccessToken(accessTokenCredentials, appConfig.getNibssApiKey());
        System.out.println(accessToken.getAccess_token());
        assertThat(accessToken).isNotNull();
        assertThat(accessToken.getToken_type()).isEqualTo("Bearer");

    }


}