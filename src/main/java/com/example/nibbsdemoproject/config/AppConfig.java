package com.example.nibbsdemoproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
//    @Value("${nibss.client.id}")
//    private String nibssClientId;
//    @Value("${nibss.client.secret}")
//    private String nibssClientSecret;
//    @Value("${nibss.scope}")
//    private String nibssScope;
//    @Value("${nibss.grant.type}")
//    private String nibssGrantType;
    @Value("${nibss.apikey}")
    private String nibssApiKey;

//    @Value("${coralPayNqr.password}")
//    private String coralPayPassword;
//    @Value("${coralPayNqr.user.name}")
//    private String coralPayUserName;
//    @Value("${coralPayNqr.client.id}")
//    private String coralPayClientId;

//    public String getCoralPayPassword() {
//        return coralPayPassword;
//    }
//
//    public String getCoralPayUserName() {
//        return coralPayUserName;
//    }
//
//    public String getCoralPayClientId() {
//        return coralPayClientId;
//    }
//
//    public String getNibssClientId() {
//        return nibssClientId;
//    }
//
//    public String getNibssClientSecret() {
//        return nibssClientSecret;
//    }
//
//    public String getNibssScope() {
//        return nibssScope;
//    }
//
//    public String getNibssGrantType() {
//        return nibssGrantType;
//    }

    public String getNibssApiKey() {
        return nibssApiKey;
    }

    @Bean
    public RestClient restClient() {
        RestTemplate oldRestTemplate = new RestTemplate();
        return RestClient.create(oldRestTemplate);
    }
}



