package com.example.nibbsdemoproject.mandateMangement.dto.response;

import lombok.Data;

@Data
public class NibssCreateMandateResponse {
    private String responseCode;
    private String mandateCode;
    private String subscriberCode;
    private String phoneNumber;
    private String responseDescription;
}
