package com.example.nibbsdemoproject.mandateMangement.service.implementation;

import com.example.nibbsdemoproject.config.AppConfig;
import com.example.nibbsdemoproject.exception.KarraboException;
import com.example.nibbsdemoproject.mandateMangement.dto.request.CreateMandateRequest;
import com.example.nibbsdemoproject.mandateMangement.dto.response.NibssCreateMandateResponse;
import com.example.nibbsdemoproject.mandateMangement.service.interfaces.NibssMandateManagement;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse.NibssAuthenticationResponse;
import com.example.nibbsdemoproject.utills.NibssAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@AllArgsConstructor
public class NibssMandateManagementImplementation implements NibssMandateManagement {
    AppConfig appConfig;
    RestClient restClient;
    @Override
    public NibssAuthenticationResponse generateAccessToken(GetAccessTokenRequest request) throws KarraboException {
        return NibssAuthentication.generateAccessToken(request, appConfig.getMandateManagementApikey());
    }

    @Override
    public NibssCreateMandateResponse createMandate(CreateMandateRequest request) throws KarraboException {
        NibssAuthenticationResponse nibssAuthenticationResponse = getAccessTokenRequest();

        try {
            NibssCreateMandateResponse response = restClient.post()
                    .uri("https://apitest.nibss-plc.com.ng/mandate/v1/e-mandate-account")
                    .header("Authorization", "Bearer " + nibssAuthenticationResponse.getAccess_token())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .body(NibssCreateMandateResponse.class);
            assert response != null;
            if (response.getResponseCode().equals("00")) return response;
        } catch (Exception e) {
            throw new KarraboException("Create mandate request not successful please try again\n"  + e.getMessage());
        }
        throw new KarraboException("Create mandate request not successful please try again\n");
    }


    private NibssAuthenticationResponse getAccessTokenRequest() throws KarraboException {
        GetAccessTokenRequest accessTokenCredentials = GetAccessTokenRequest
                .builder()
                .client_id(appConfig.getMandateManagementClientId())
                .client_secret(appConfig.getMandateManagementClientSecret())
                .scope(appConfig.getMandateManagementClientId()+"/.default")
                .grant_type(appConfig.getMandateManagementGrantType())
                .build();
        return generateAccessToken(accessTokenCredentials);
    }
}
