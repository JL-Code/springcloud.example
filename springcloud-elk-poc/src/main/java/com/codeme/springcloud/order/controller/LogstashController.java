package com.codeme.springcloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>创建时间: 2021/1/25 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@Slf4j
@RestController
public class LogstashController {

    @GetMapping("/log")
    public String getLog(String message) {
        log.info(message);
        return "ok";
    }

    @PostMapping("/log")
    public String postLog(String message) {
        log.error(message);
        return "ok";
    }
}
