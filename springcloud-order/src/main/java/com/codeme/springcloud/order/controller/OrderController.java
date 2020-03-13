package com.codeme.springcloud.order.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private final String serviceHost = "http://localhost:8001";
    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/payment/{id}")
    public String getPayment(@PathVariable String id) {
        String result = restTemplate.getForObject(serviceHost + "/payment/" + id, String.class);
        return result;
    }
}
