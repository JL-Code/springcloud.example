package com.codeme.springcloud.payment.service.impl;

import com.codeme.springcloud.payment.entities.Payment;
import com.codeme.springcloud.payment.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/3/16 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public Payment getPaymentById(Long id) {
        log.info("getPaymentById id:" + id);
        return new Payment(id, 12);
    }
}
