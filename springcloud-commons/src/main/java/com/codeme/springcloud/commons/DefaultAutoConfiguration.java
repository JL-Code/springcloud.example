package com.codeme.springcloud.commons;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/7/2 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@Configuration
@EnableFeignClients(basePackages = "com.codeme.springcloud.commons.openfeign")
public class DefaultAutoConfiguration {
}
