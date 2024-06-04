package com.example.nibbsdemoproject.mandateMangement.service.interfaces;

import com.example.nibbsdemoproject.exception.KarraboException;
import com.example.nibbsdemoproject.mandateMangement.dto.request.CreateMandateRequest;
import com.example.nibbsdemoproject.mandateMangement.dto.response.NibssCreateMandateResponse;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse.NibssAuthenticationResponse;

public interface NibssMandateManagement {
    NibssAuthenticationResponse generateAccessToken(GetAccessTokenRequest request) throws KarraboException;
    NibssCreateMandateResponse createMandate(CreateMandateRequest request) throws KarraboException;


}
