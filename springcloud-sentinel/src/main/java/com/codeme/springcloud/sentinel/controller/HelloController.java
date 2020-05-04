package com.codeme.springcloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/sentinel/hello")
    public String hello() {
        return "hello sentinel";
    }

    @GetMapping("/sentinel/hello2")
    public String hello2() {
        return "hello sentinel";
    }
}
