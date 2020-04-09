package com.codeme.springcloud.hystrix.controller;

import com.codeme.springcloud.hystrix.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

    private final PaymentService paymentService;

    public HystrixController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/hystrix/payment/timeout")
    public String hello(String id) {
        String result=  paymentService.getPaymentByIdTimeout();
        return result;
    }
}
