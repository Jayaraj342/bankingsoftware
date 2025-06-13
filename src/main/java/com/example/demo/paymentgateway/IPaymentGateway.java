package com.example.demo.paymentgateway;

public interface IPaymentGateway {
    String getPayLink(
            String name,
            String phoneNo,
            String email,
            String orderId
    );
}
