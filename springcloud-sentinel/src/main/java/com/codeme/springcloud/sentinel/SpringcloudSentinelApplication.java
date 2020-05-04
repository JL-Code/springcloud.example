package com.codeme.springcloud.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudSentinelApplication.class, args);
    }

}
