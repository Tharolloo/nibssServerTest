package com.example.nibbsdemoproject.nibssPayPlus.controller;

import com.example.nibbsdemoproject.exception.KarraboException;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse.AddDebitAccountResponse;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse.NibssAuthenticationResponse;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.AddDebitAccountRequest;
import com.example.nibbsdemoproject.nibssPayPlus.services.interfaces.NibssPayPlus;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/nibssPayPlus/")
@AllArgsConstructor
public class NibssPayController {

    private final NibssPayPlus nibssPayPlus;

    @PostMapping("addDebitAccount")
    public ResponseEntity<?> addDebitAccount(@RequestBody AddDebitAccountRequest request) throws KarraboException {
        AddDebitAccountResponse addDebitAccountResponse = nibssPayPlus.addDebitAccount(request);
        return ResponseEntity.status(HttpStatus.OK).body(addDebitAccountResponse);

    }

    @PostMapping("getAccessToken")
    public ResponseEntity<?> getAccessToken(@RequestBody GetAccessTokenRequest request) throws KarraboException {
        NibssAuthenticationResponse accessToken = nibssPayPlus.getAccessToken(request);
        return ResponseEntity.status(HttpStatus.OK).body(accessToken);
    }

}
