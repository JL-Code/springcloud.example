package com.codeme.springcloud.hystrix.service.impl;

import com.codeme.springcloud.hystrix.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String getPaymentByIdNormal() {
        return "normal";
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPaymentByIdTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String getPaymentByIdTimeout() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String getPaymentByIdError() {
        int num = 10 / 0;
        return "error";
    }

    public String getPaymentByIdTimeoutHandler() {
        return "当前处理的线程ID：" + Thread.currentThread().getId() + " 超时了 /(ㄒoㄒ)/~~ FallBack";
    }
}
