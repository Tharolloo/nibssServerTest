package com.example.nibbsdemoproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Value("${nibss.apikey}")
    private String nibssApiKey;

    @Value("${nibss.mandate.management.apikey}")
    private String mandateManagementApikey;

    @Value("${nibss.mandate.management.client.id}")
    private String mandateManagementClientId;

    @Value("${nibss.mandate.management.client.secret}")
    private String mandateManagementClientSecret;
    @Value("${nibss.mandate.management.scope}")
    private String mandateManagementScope;
    @Value("${nibss.mandate.management.grant.type}")
    private String mandateManagementGrantType;

    @Value("${nibss.mandate.management.auth.username}")
    private String mandateManagementAuthUserName;

    @Value("${nibss.mandate.management.auth.password}")
    private String mandateManagementAuthPassword;

    @Value("${nibss.mandate.management.auth.apikey}")
    private String mandateManagementAuthApikey;


    public String getMandateManagementAuthUserName() {
        return mandateManagementAuthUserName;
    }

    public String getMandateManagementAuthPassword() {
        return mandateManagementAuthPassword;
    }

    public String getMandateManagementAuthApikey() {
        return mandateManagementAuthApikey;
    }

    public String getNibssApiKey() {
        return nibssApiKey;
    }
    public String getMandateManagementApikey() {
        return mandateManagementApikey;
    }

    public String getMandateManagementClientId() {
        return mandateManagementClientId;
    }

    public String getMandateManagementClientSecret() {
        return mandateManagementClientSecret;
    }

    public String getMandateManagementScope() {
        return mandateManagementScope;
    }

    public String getMandateManagementGrantType() {
        return mandateManagementGrantType;
    }

    @Bean
    public RestClient restClient() {
        RestTemplate oldRestTemplate = new RestTemplate();
        return RestClient.create(oldRestTemplate);
    }
}



