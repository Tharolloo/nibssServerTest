package com.example.nibbsdemoproject.nibssPayPlus.services.implementation;

import com.example.nibbsdemoproject.config.AppConfig;
import com.example.nibbsdemoproject.exception.KarraboException;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.AddDebitAccount;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.AddDebitAccountRequest;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse.AddDebitAccountResponse;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse.NibssAuthenticationResponse;
import com.example.nibbsdemoproject.nibssPayPlus.services.interfaces.NibssPayPlus;
import com.example.nibbsdemoproject.utills.NibssAuthentication;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
    public NibssAuthenticationResponse getAccessToken(GetAccessTokenRequest request) throws KarraboException {
        return NibssAuthentication.generateAccessToken(request, appConfig.getNibssApiKey());
    }

    @Override
    public AddDebitAccountResponse addDebitAccount(AddDebitAccountRequest request) throws KarraboException {
        GetAccessTokenRequest tokenRequest = GetAccessTokenRequest.builder()
                .client_secret(request.getClient_secret())
                .client_id(request.getClient_id())
                .scope(request.getScope())
                .grant_type(request.getGrant_type())
                .build();

        NibssAuthenticationResponse accessToken = getAccessToken(tokenRequest);

        AddDebitAccount addDebitAccount = new AddDebitAccount();

        BeanUtils.copyProperties(request, addDebitAccount);

        log.info("Add debit Account ------------------>>>>>>>>>  "+   addDebitAccount);


        String token = accessToken.getAccess_token();

        return restClient.
                post()
                .uri("https://apitest.nibss-plc.com.ng/nibsspayplus/v2/Accounts")
                .header("Authorization", "Bearer "+token)
                .header("accept", "application/json")
                .contentType(MediaType.APPLICATION_JSON)
                .body(addDebitAccount)
                .retrieve()
                .body(AddDebitAccountResponse.class);
    }
}
