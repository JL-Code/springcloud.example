package com.codeme.springcloud.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationContext {

    // @LoadBalanced 注解开启后就可以通过微服务名称（instance-id）访问服务
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @LoadBalanced
    public  WebClient.Builder getWebClient() {
        return WebClient.builder();
    }
}
