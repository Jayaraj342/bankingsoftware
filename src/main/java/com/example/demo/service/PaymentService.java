package com.example.demo.service;

import com.example.demo.paymentgateway.IPaymentGateway;
import com.example.demo.paymentgateway.PaymentGatewayStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentGatewayStrategy paymentGatewayStrategy;

    public String getPaymentLink(
            String name,
            String phoneNo,
            String email,
            String orderId
    ) {
        IPaymentGateway bestPaymentGateway = paymentGatewayStrategy.getBestPaymentGateway();
        return bestPaymentGateway.getPayLink(
                name,
                phoneNo,
                email,
                orderId
        );
    }
}
