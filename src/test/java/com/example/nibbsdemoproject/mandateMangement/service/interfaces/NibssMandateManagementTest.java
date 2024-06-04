package com.example.nibbsdemoproject.mandateMangement.service.interfaces;

import com.example.nibbsdemoproject.config.AppConfig;
import com.example.nibbsdemoproject.exception.KarraboException;
import com.example.nibbsdemoproject.mandateMangement.dto.model.Auth;
import com.example.nibbsdemoproject.mandateMangement.dto.model.MandateRequest;
import com.example.nibbsdemoproject.mandateMangement.dto.request.CreateMandateRequest;
import com.example.nibbsdemoproject.mandateMangement.dto.response.NibssCreateMandateResponse;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest.GetAccessTokenRequest;
import com.example.nibbsdemoproject.nibssPayPlus.dto.nibssResponse.NibssAuthenticationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class NibssMandateManagementTest {
    @Autowired
    NibssMandateManagement nibssMandateManagement;

    @Autowired
    AppConfig appConfig;

    @Test
    void generateAccessToken() throws KarraboException {
        GetAccessTokenRequest accessTokenCredentials = GetAccessTokenRequest
                .builder()
                .client_id(appConfig.getMandateManagementClientId())
                .client_secret(appConfig.getMandateManagementClientSecret())
                .scope(appConfig.getMandateManagementScope())
                .grant_type(appConfig.getMandateManagementGrantType())
                .build();


        NibssAuthenticationResponse accessToken = nibssMandateManagement.generateAccessToken(accessTokenCredentials);
        System.out.println(accessToken.getAccess_token());
        assertThat(accessToken).isNotNull();
        assertThat(accessToken.getToken_type()).isEqualTo("Bearer");
    }

    @Test
    void generateAccessTokenThrowsKarraboException() {
        GetAccessTokenRequest accessTokenCredentials = GetAccessTokenRequest
                .builder()
                .client_id(appConfig.getMandateManagementClientId())
                .client_secret("RsI8Q~BHXVBtS2l2F1UU3")
                .scope("95fafe19-bf8a-439e-b31c77e/.default")
                .grant_type("client_")
                .build();
        assertThrows(KarraboException.class, ()->nibssMandateManagement.generateAccessToken(accessTokenCredentials));
    }



    private CreateMandateRequest buildCreateMandate() {

        MandateRequest mandateRequest = MandateRequest.builder()
                .accountName("Wilma Okoli").accountNumber("2222222223").amount("50").bankCode("998").emailAddress("hechebiri@nibss-plc.com.ng")
                .endDate("20231219").fileExtension("png").frequency(0)
                .fileBase64EncodedString("iVBORw0KGgoAAAANSUhEUgAAAHIAAAASCAYAAACHKYonAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsIAAA7CARUoSoAAAA/HSURBVGhDxVkHdFVVuv7OufcmN4UUIkEgRghESJBgaEIojggCT1DmsbCM88QyIsqs0QEpFvA9cZQXxGlSw6KDrAEiHRELQhAQEupESAiEHpJQ0m6/57zv3zcnlOfzsd48hj/rv/ucXf6z99//He3q1avmli1bEBYWhjsN4eHhsNls9W/XQCOaocfbBoFAAD6fTz0PHToU+/fvx4kTJ35yPzeAxt3pOhu2gtypaXC3hsHHW9m1rNNDqIBrZJ3J9f/LqU3OczqdGDRoELRly5aZycnJSEpKUgOC/0wQBsg34+LisCMvD2fPnEW4PRzBYBC6ZsJl8yNgc0D322DTgxC2hgVsMOCBYdP5zmfhxT+wbRFiWloaMjMzsXjxYjz55JOYNm0aJk6cCJfLVT9LgB9RQrNBj3BCj4wkv4Pwl1+Er6oGAY8PdocDdp7F0TQedrsTQbeL6AYPROEKDRE8T8ExzSbr3TDcl2H6amAE"
                ).Narration("Test caching of prod id 4").payeeAddress("1230 Ahmadu bello").payeeName("OG INC NIBSS").payerName("WILNI")
                .phoneNumber("08067036022").payerAddress("Adeola Hopewell").productId("1").startDate("20221219").subscriberCode("EMS/we the best4")
                .build();

        Auth auth = Auth.builder()
                .username(appConfig.getMandateManagementAuthUserName())
                .password(appConfig.getMandateManagementAuthPassword())
                .apiKey(appConfig.getMandateManagementAuthApikey())
                .build();

        return CreateMandateRequest.builder()
                .mandateRequest(List.of(mandateRequest))
                .auth(auth)
                .build();
    }
}