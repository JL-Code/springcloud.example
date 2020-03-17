package com.codeme.springcloud.payment.controller;

import com.codeme.springcloud.commons.controller.ApiControllerBase;
import com.codeme.springcloud.payment.service.impl.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/3/17 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@RestController
@RequiredArgsConstructor
public class WebTestController extends ApiControllerBase {

    private final GreetingService greetingService;

    @GetMapping("/web-test/test")
    public ResponseEntity test() {
        String msg = greetingService.greet();
        return ok(msg);
    }
}
