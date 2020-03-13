package com.codeme.springcloud.order.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    /**
     * 客户端通过 instance-id 访问 eg: PAYMENT-SERVICE (应用注册名)
     */
    private final String paymentService = "http://PAYMENT-SERVICE";
    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/payment/{id}")
    public String getPayment(@PathVariable String id) {
        String result = restTemplate.getForObject(paymentService + "/payment/" + id, String.class);
        return result;
    }
}
