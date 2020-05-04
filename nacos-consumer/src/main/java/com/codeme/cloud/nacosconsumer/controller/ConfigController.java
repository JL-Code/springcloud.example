package com.codeme.cloud.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    private final Environment env;

    public ConfigController(Environment env) {
        this.env = env;
    }


    /**
     * Nacos 实时获取变更的服务配置信息
     *
     * @return
     */
    @GetMapping("/consumer/nacos/config")
    public String configInfo() {
        String config = "";
        config += env.getProperty("info");
        config += env.getProperty("spring.datasource.url");
        config += env.getProperty("spring.datasource.type");
        config += env.getProperty("spring.datasource.username");
        config += env.getProperty("spring.datasource.password");
        config += env.getProperty("spring.datasource.driver-class-name");
        return config;
    }
}
