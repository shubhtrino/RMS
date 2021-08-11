package com.trino.ratemanagementsystem.RMS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class webClientConfiguration {

    @Bean
    public WebClient getWebClient(){
        return   WebClient.create();
    }
}
