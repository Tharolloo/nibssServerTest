package com.example.nibbsdemoproject.controller;

import com.example.nibbsdemoproject.dto.nibssRequest.AddDebitAccountRequest;
import com.example.nibbsdemoproject.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.dto.nibssResponse.AddDebitAccountResponse;
import com.example.nibbsdemoproject.dto.nibssResponse.NibssAuthenticationResponse;
import com.example.nibbsdemoproject.services.nibssService.interfaces.NibssPayPlus;
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
    public ResponseEntity<?> addDebitAccount(@RequestBody AddDebitAccountRequest request){
        AddDebitAccountResponse addDebitAccountResponse = nibssPayPlus.addDebitAccount(request);
        return ResponseEntity.status(HttpStatus.OK).body(addDebitAccountResponse);
    }

    @PostMapping("getAcccesToken")
    public ResponseEntity<?> getAccesToken(@RequestBody GetAccessTokenRequest request){
        NibssAuthenticationResponse accessToken = nibssPayPlus.getAccessToken(request);
        return ResponseEntity.status(HttpStatus.OK).body(accessToken);
    }

}
