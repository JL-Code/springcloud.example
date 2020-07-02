package com.codeme.springcloud.commons.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/7/2 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@FeignClient(name = "PAYMENT-SERVICE", contextId = "commons")
public interface PaymentService {
    @RequestMapping(method = RequestMethod.GET, value = "/payment/{id}", consumes = "application/json")
    Payment getPaymentById(@PathVariable("id") Long id);
}
