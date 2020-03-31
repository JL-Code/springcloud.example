package com.codeme.springcloud.ribbonorder.service;

import com.codeme.springcloud.ribbonorder.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/3/31 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@Component
@FeignClient("PAYMENT-SERVICE")
public interface PaymentService {
    @RequestMapping(method = RequestMethod.GET, value = "/payment/{id}", consumes = "application/json")
    Payment getPaymentById(@PathVariable("id") Long id);
}
