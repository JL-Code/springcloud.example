package com.codeme.springcloud.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/logstash")
public class LogstashController {

    @GetMapping("hello")
    public String hello(String content) {
        log.error("content: " + content);
        return "logstash hello";
    }

    @GetMapping("hello2")
    public String hello2(String content) {
        log.error("content2: " + content);
        System.out.println("content2: " + content);
        return "logstash hello2";
    }
}
