package com.example.demo.paymentgateway;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
@AllArgsConstructor
public class RazorpayPaymentGateway implements IPaymentGateway {

    private final RazorpayClient razorpayClient;

    @Override
    public String getPayLink(
            String name,
            String phoneNo,
            String email,
            String orderId
    ) {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", 1000);// 1000 paise = 10 Rupees
        paymentLinkRequest.put("currency", "INR");
        paymentLinkRequest.put("accept_partial", true);
        paymentLinkRequest.put("first_min_partial_amount", 100);

        long millis = Instant.now().plus(20, ChronoUnit.MINUTES).toEpochMilli();
        paymentLinkRequest.put("expire_by", millis);

        paymentLinkRequest.put("reference_id", orderId);
        paymentLinkRequest.put("description", "Payment for policy no #23456");

        JSONObject customer = new JSONObject();
        customer.put("name", name);
        customer.put("contact", phoneNo);
        customer.put("email", email);
        paymentLinkRequest.put("customer", customer);

        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);

        paymentLinkRequest.put("reminder_enable", true);

        JSONObject notes = new JSONObject();
        notes.put("policy_name", "Jeevan Bima");
        paymentLinkRequest.put("notes", notes);

        paymentLinkRequest.put("callback_url", "http://localhost:8080/api/v1/demo?input=paymentDone");
        paymentLinkRequest.put("callback_method", "get");

        try {
            PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
            return payment.get("short_url");
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }
    }
}
