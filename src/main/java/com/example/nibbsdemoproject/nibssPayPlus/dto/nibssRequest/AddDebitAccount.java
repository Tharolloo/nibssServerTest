package com.example.nibbsdemoproject.nibssPayPlus.dto.nibssRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Data
public class AddDebitAccount {
    @JsonProperty("accounts")
    private List<Account> account;
}
