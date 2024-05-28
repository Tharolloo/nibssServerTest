package com.example.nibbsdemoproject.services.nibssService.interfaces;

import com.example.nibbsdemoproject.dto.nibssRequest.AddDebitAccountRequest;
import com.example.nibbsdemoproject.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.dto.nibssResponse.AddDebitAccountResponse;
import com.example.nibbsdemoproject.dto.nibssResponse.NibssAuthenticationResponse;

public interface NibssPayPlus {

    NibssAuthenticationResponse getAccessToken(GetAccessTokenRequest getAccessTokenRequest);


    AddDebitAccountResponse addDebitAccount(AddDebitAccountRequest request);
}

