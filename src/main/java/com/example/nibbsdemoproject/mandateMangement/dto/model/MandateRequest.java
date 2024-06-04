package com.example.nibbsdemoproject.mandateMangement.dto.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MandateRequest {

    private String accountNumber;
    private String productId;
    private String bankCode;
    private String payerName;
    private String payerAddress;
    private String accountName;
    private String amount;
    private String payeeName;
    private String Narration;
    private String payeeAddress;
    private String phoneNumber;
    private String emailAddress;
    private String subscriberCode;
    private String startDate;
    private String endDate;
    private String fileExtension;
    private String fileBase64EncodedString;
    private long frequency;


}
