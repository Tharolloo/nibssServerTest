package com.example.nibbsdemoproject.services.nibssService.interfaces;

import com.example.nibbsdemoproject.dto.nibssRequest.Account;
import com.example.nibbsdemoproject.dto.nibssRequest.AddDebitAccountRequest;
import com.example.nibbsdemoproject.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.dto.nibssResponse.AddDebitAccountResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NibssPayPlusTest {

    @Autowired
    private NibssPayPlus nibssPayPlus;


    private AddDebitAccountRequest buildAddDebitAccountRequest() {
        Account account = Account.builder()
                .accountNumber("0112345678")
                .accountName("vee Test")
                .commonName("arKCz83xBv1scTwhATmOGbt2XQOC3am7ROgGATtC2ydEe1Wy1S")
                .bankCode("998")
                .build();

        return AddDebitAccountRequest.builder()
                .account(List.of(account))
                .client_id("876cca27-6e23-4218-be18-87a1d2d4f195")
                .client_secret("ZyV8Q~WGBjyj2v57GpywxPaHMXNqYEE2A26E5cQ.")
                .scope("876cca27-6e23-4218-be18-87a1d2d4f195/.default")
                .grant_type("client_credentials")
                .build();
    }





}