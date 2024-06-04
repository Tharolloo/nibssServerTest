package com.example.nibbsdemoproject.nibssPayPlus.services.interfaces;

import com.example.nibbsdemoproject.exception.KarraboException;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.AddDebitAccountRequest;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse.AddDebitAccountResponse;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse.NibssAuthenticationResponse;

public interface NibssPayPlus {

    NibssAuthenticationResponse getAccessToken(GetAccessTokenRequest getAccessTokenRequest) throws KarraboException;


    AddDebitAccountResponse addDebitAccount(AddDebitAccountRequest request) throws KarraboException;
}

