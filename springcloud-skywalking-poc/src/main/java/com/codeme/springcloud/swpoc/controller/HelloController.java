package com.codeme.springcloud.swpoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>创建时间: 2020/9/28 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        return "hello for skywalking" + new Date();
    }
}
