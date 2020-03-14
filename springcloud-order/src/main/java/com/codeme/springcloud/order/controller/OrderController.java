package com.codeme.springcloud.order.controller;

import com.codeme.springcloud.commons.controller.ApiControllerBase;
import com.codeme.springcloud.commons.dto.ApiResultDTO;
import com.codeme.springcloud.commons.vo.ApiResultBaseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
public class OrderController extends ApiControllerBase {

    /**
     * 客户端通过 instance-id 访问 eg: PAYMENT-SERVICE (应用注册名)
     */
    private final String paymentService = "http://PAYMENT-SERVICE";
    private final RestTemplate restTemplate;
    private final WebClient.Builder webClientBuilder;

    public OrderController(RestTemplate restTemplate, WebClient.Builder webClientBuilder) {
        this.restTemplate = restTemplate;
        this.webClientBuilder = webClientBuilder;
    }

    @GetMapping("/consumer/payment/{id}")
    public ResponseEntity getPayment(@PathVariable String id) {
        try {
            ResponseEntity<ApiResultBaseVO> result = restTemplate.getForEntity(paymentService + "/payment/" + id, ApiResultBaseVO.class);
            return ok(result);
        } catch (Exception e) {
            return fail(500, e.getMessage());
        }
    }

    @GetMapping(value = "/consumer/tweets-non-blocking",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ApiResultDTO> getTweetsNonBlocking() {
        log.info("Starting NON-BLOCKING Controller!");
        Flux<ApiResultDTO> tweetFlux = webClientBuilder.build()
                .get()
                .uri(paymentService + "/slow-service-tweets")
                .retrieve()
                .bodyToFlux(ApiResultDTO.class);

        tweetFlux.subscribe(tweet -> log.info(tweet.toString()));
        log.info("Exiting NON-BLOCKING Controller!");
        return tweetFlux;
    }

}
