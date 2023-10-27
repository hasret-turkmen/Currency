package com.hasret.currency.config;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BinanceApiClientConfig {

    //added to application.properities
    @Value("${binance.apiKey}")
    private String apiKey;

    @Value("${binance.apiSecret}")
    private String apiSecret;

    @Bean
    public BinanceApiRestClient apiClient(){
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apiKey,apiSecret);
        return factory.newRestClient();
    }
}
