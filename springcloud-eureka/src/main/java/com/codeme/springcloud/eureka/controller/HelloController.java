package com.codeme.springcloud.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建时间: 2020/10/29 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@RestController
public class HelloController {

    @Autowired
    Environment env;

    @Value("${eureka.instance.hostname}")
    private String hostname;

    @GetMapping("/hello")
    public Object hello() {
        return "hello for eureka hostname：" + hostname;
    }

    @GetMapping("/properties")
    public Map<String, Object> allProperties() {
        Map<String, Object> map = new HashMap<>();
        map.put("activeProfiles", env.getActiveProfiles());
        map.put("defaultProfiles", env.getDefaultProfiles());

        MutablePropertySources sources = ((AbstractEnvironment) env).getPropertySources();
        for (PropertySource<?> source : sources) {
            if (source instanceof EnumerablePropertySource) {
                EnumerablePropertySource propertySource = (EnumerablePropertySource) source;
                for (String s : propertySource.getPropertyNames()) {
                    map.put(s, propertySource.getProperty(s));
                }
            }
        }
        return map;
    }
}
