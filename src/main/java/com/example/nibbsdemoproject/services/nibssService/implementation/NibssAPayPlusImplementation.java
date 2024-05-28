package com.example.nibbsdemoproject.services.nibssService.implementation;

import com.example.nibbsdemoproject.config.AppConfig;
import com.example.nibbsdemoproject.dto.nibssRequest.AddDebitAccountRequest;
import com.example.nibbsdemoproject.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.dto.nibssResponse.AddDebitAccountResponse;
import com.example.nibbsdemoproject.dto.nibssResponse.NibssAuthenticationResponse;
import com.example.nibbsdemoproject.services.nibssService.interfaces.NibssPayPlus;
import com.example.nibbsdemoproject.utills.NibssAuthentication;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@AllArgsConstructor
@Slf4j
public class NibssAPayPlusImplementation implements NibssPayPlus {
    private final AppConfig appConfig;
    private final RestClient restClient;
    @Override
    public NibssAuthenticationResponse getAccessToken(GetAccessTokenRequest request){
        return NibssAuthentication.generateAccessToken(request, appConfig.getNibssApiKey());
    }

    @Override
    public AddDebitAccountResponse addDebitAccount(AddDebitAccountRequest request) {
        GetAccessTokenRequest tokenRequest = GetAccessTokenRequest.builder()
                .client_secret(request.getClient_secret())
                .client_id(request.getClient_id())
                .scope(request.getScope())
                .grant_type(request.getGrant_type())
                .build();

        NibssAuthenticationResponse accessToken = getAccessToken(tokenRequest);

        String token = accessToken.getAccess_token();

        return restClient.
                post()
                .uri("https://apitest.nibss-plc.com.ng/nibsspayplus/v2/Accounts")
                .header("Authorization", "Bearer "+token)
                .header("accept", "application/json")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(AddDebitAccountResponse.class);
    }
}
