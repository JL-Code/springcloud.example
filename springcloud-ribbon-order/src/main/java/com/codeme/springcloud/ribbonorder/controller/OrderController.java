package com.codeme.springcloud.ribbonorder.controller;

import com.codeme.springcloud.commons.controller.ApiControllerBase;
import com.codeme.springcloud.commons.openfeign.Payment;
import com.codeme.springcloud.commons.openfeign.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/3/30 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@RestController
public class OrderController extends ApiControllerBase {

    private final PaymentService paymentService;

    public OrderController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment/{id}")
    public ResponseEntity getPayment(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return ok(payment);
    }

    @GetMapping("/payment")
    public Long testPayment(@PathVariable Long id) {
        return id;
    }

    @GetMapping("/payment/timeout")
    public ResponseEntity timeout() {
        Payment payment = paymentService.getPaymentOfTimeout();
        return ok(payment);
    }
}
