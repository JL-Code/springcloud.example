package com.codeme.springcloud.payment.controller;

import com.codeme.springcloud.commons.controller.ApiControllerBase;
import com.codeme.springcloud.commons.dto.ApiResultDTO;
import com.codeme.springcloud.payment.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PaymentController extends ApiControllerBase {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = new Payment();
        payment.setId(1000L);
        payment.setSerial(100);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (id > 10) {
            return ok(payment);
        } else {
            return notFound("没有找到 id:" + id + "serverPort:" + serverPort);
        }
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
