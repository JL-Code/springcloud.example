package com.codeme.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class SpringcloudHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudHystrixApplication.class, args);
    }

}
