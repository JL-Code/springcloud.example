package com.codeme.springcloud.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p>描述: 启动类 </p>
 * <p>创建时间: 2020/3/12 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain.class, args);
    }
}
