package com.example.demo.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class RazorpayConfig {

    @Value("${payment-gateway.razorpay.key}")
    private String key;

    @Value("${payment-gateway.razorpay.secret}")
    private String secret;

    @Bean
    public RazorpayClient getRazorpayClient() throws RazorpayException {
        return new RazorpayClient(key, secret);
    }
}
