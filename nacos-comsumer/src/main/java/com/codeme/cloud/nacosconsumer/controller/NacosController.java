package com.codeme.cloud.nacosconsumer.controller;

import com.codeme.cloud.nacosconsumer.service.NacosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosController {

    private final NacosService nacosService;

    public NacosController(NacosService nacosService) {
        this.nacosService = nacosService;
    }

    @GetMapping("/consumer/nacos/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        // 利用 openfeign 以本地服务的方式调用
        String response = nacosService.getHello(name);
        return response;
    }
}
