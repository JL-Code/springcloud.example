package com.codeme.springcloud.ribbonorder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>创建时间: 2020/9/24 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        log.error("hello error");
        return "hello for order";
    }
}
