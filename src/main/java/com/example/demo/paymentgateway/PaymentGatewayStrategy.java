package com.example.demo.paymentgateway;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentGatewayStrategy {

    private final RazorpayPaymentGateway razorpayPaymentGateway;
    private final StripePaymentGateway stripePaymentGateway;

    public IPaymentGateway getBestPaymentGateway() {
        return stripePaymentGateway;
    }
}
