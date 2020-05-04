package com.codeme.springcloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @SentinelResource("hello")
    @GetMapping("/sentinel/hello")
    public String hello() {
        return "hello sentinel";
    }
}
