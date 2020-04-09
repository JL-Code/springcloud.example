package com.codeme.springcloud.payment.service;

import com.codeme.springcloud.payment.entities.*;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/3/16 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
public interface PaymentService {
    Payment getPaymentById(Long id);
}
