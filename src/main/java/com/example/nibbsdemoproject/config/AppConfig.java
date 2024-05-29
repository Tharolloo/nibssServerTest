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

    public String getNibssApiKey() {
        return nibssApiKey;
    }

    @Bean
    public RestClient restClient() {
        RestTemplate oldRestTemplate = new RestTemplate();
        return RestClient.create(oldRestTemplate);
    }
}



