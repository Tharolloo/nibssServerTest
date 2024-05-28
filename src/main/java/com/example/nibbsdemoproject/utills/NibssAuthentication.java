package com.example.nibbsdemoproject.utills;

import com.example.nibbsdemoproject.config.AppConfig;
import com.example.nibbsdemoproject.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.dto.nibssResponse.NibssAuthenticationResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class NibssAuthentication {

    public static NibssAuthenticationResponse generateAccessToken(GetAccessTokenRequest request, String apiKey){
        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey",apiKey);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", request.getClient_id());
        formData.add("client_secret", request.getClient_secret());
        formData.add("scope", request.getScope());
        formData.add("grant_type", request.getGrant_type());

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(formData, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<NibssAuthenticationResponse> response = restTemplate.postForEntity("https://apitest.nibss-plc.com.ng/v2/reset", httpEntity, NibssAuthenticationResponse.class);

        return response.getBody();

    }

}
