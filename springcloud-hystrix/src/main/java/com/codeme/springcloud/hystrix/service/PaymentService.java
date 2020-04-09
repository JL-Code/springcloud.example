package com.codeme.springcloud.hystrix.service;

public interface PaymentService {
    String getPaymentByIdNormal();
    String getPaymentByIdTimeout();
    String getPaymentByIdError();
}
