package com.example.nibbsdemoproject.mandateMangement.controller;

import com.example.nibbsdemoproject.exception.KarraboException;
import com.example.nibbsdemoproject.mandateMangement.dto.request.CreateMandateRequest;
import com.example.nibbsdemoproject.mandateMangement.dto.response.NibssCreateMandateResponse;
import com.example.nibbsdemoproject.mandateMangement.service.interfaces.NibssMandateManagement;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse.NibssAuthenticationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nibssmandate/")
@AllArgsConstructor
public class NibssMandateManagementController {

    private final NibssMandateManagement nibssMandateManagement;


    @PostMapping("mandateAuthentication")
    public ResponseEntity<?> authenticate(@RequestBody GetAccessTokenRequest getAccessTokenRequest) throws KarraboException {
        NibssAuthenticationResponse nibssAuthenticationResponse = nibssMandateManagement.generateAccessToken(getAccessTokenRequest);
        return ResponseEntity.status(HttpStatus.OK).body(nibssAuthenticationResponse);

    }

    @PostMapping("createmandate")
    public ResponseEntity<?> createMandate(@RequestBody CreateMandateRequest createMandateRequest) throws KarraboException {
        NibssCreateMandateResponse mandate = nibssMandateManagement.createMandate(createMandateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(mandate);

    }
}
