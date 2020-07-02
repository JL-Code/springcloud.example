package com.codeme.springcloud.ribbonorder.config;

import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/7/2 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@Slf4j
@Configuration
public class PaymentFeignConfiguration {
    public PaymentFeignConfiguration() {
        log.info("PaymentFeignConfiguration...");
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
