package com.codeme.springcloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class NacosHelloController {

    @Value("${server.port}")
    private String serverPort;
    @Value("${project.version:0.0.0}")
    private String version;

    @GetMapping("/consumer/nacos/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return "nacos hello: " + serverPort + "name:" + name;
    }

    @GetMapping("/consumer/nacos/config")
    public String config() {
        return "nacos hello: " + serverPort + "config:" + version;
    }
}
