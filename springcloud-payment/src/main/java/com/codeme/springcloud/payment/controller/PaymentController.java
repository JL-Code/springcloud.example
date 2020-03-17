package com.codeme.springcloud.payment.controller;

import com.codeme.springcloud.commons.controller.ApiControllerBase;
import com.codeme.springcloud.commons.dto.ApiResultDTO;
import com.codeme.springcloud.payment.entities.Payment;
import com.codeme.springcloud.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController extends ApiControllerBase {

    private final PaymentService paymentService;

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return ok(payment);
        }
        return notFound("没有找到 id:" + id);
    }


    @GetMapping("/slow-service-tweets")
    private List<ApiResultDTO> getAllTweets() {
        try {
            Thread.sleep(2000L); // delay
            return Arrays.asList(
                    new ApiResultDTO(1, "@user1"),
                    new ApiResultDTO(2, "@user2"),
                    new ApiResultDTO(3, "@user1"));
        } catch (Exception e) {
            return null;
        }
    }
}
