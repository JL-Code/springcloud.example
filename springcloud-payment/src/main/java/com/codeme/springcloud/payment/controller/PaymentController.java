package com.codeme.springcloud.payment.controller;

import com.codeme.springcloud.commons.controller.ApiControllerBase;
import com.codeme.springcloud.commons.dto.ApiResultDTO;
import com.codeme.springcloud.payment.entities.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class PaymentController extends ApiControllerBase {

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id) {
        Payment payment = new Payment();
        payment.setId(1000L);
        payment.setSerial(100);
        return ok(payment);
//        return notFound("没有找到 id:" + id);
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
