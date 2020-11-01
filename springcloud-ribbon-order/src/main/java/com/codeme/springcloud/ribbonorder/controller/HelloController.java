package com.codeme.springcloud.ribbonorder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>创建时间: 2020/9/24 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Environment env;

    @GetMapping("/hello")
    public Object hello() {
        return "hello for ribbon order";
    }

    @GetMapping("/properties/{key}")
    public Object hello(@PathVariable String key) {
        return key + ": " + env.getProperty(key);
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
