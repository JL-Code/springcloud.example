package com.codeme.springcloud.payment.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    @GetMapping("/payment/{id}")
    @ResponseBody
    public String getPaymentById(@PathVariable String id){
        return id;
    }
}
