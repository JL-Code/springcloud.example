package com.codeme.cloud.nacosconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * springcloud-nacos-producer 在编码前应该约定好，视为常量。
 */
@Component
@FeignClient("springcloud-nacos-producer")
public interface NacosService {
    @RequestMapping(method = RequestMethod.GET, value = "/nacos/hello/{name}", consumes = "application/json")
    String getHello(@PathVariable("name") String name);
}