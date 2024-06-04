package com.example.nibbsdemoproject.mandateMangement.dto.request;

import com.example.nibbsdemoproject.mandateMangement.dto.model.Auth;
import com.example.nibbsdemoproject.mandateMangement.dto.model.MandateRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateMandateRequest {
    @JsonProperty("auth")
    private Auth auth;
    private List<MandateRequest> mandateRequest;

}
