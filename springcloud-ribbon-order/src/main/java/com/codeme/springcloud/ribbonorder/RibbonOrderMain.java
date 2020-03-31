package com.codeme.springcloud.ribbonorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 启用 Feign 注解
public class RibbonOrderMain {
    public static void main(String[] args) {
        SpringApplication.run(RibbonOrderMain.class, args);
    }
}
