package com.codeme.springcloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosHelloController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/nacos/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "nacos hello: " + serverPort + "name:" + name;
    }
}
