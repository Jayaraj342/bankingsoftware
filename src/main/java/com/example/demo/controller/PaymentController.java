package com.example.demo.controller;

import com.example.demo.dto.PaymentDTO;
import com.example.demo.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public String getPaymentLink(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.getPaymentLink(
                paymentDTO.getName(),
                paymentDTO.getPhoneNo(),
                paymentDTO.getEmail(),
                paymentDTO.getOrderId()
        );
    }
}
