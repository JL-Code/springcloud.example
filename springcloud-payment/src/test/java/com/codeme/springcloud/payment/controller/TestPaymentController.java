package com.codeme.springcloud.payment.controller;

import com.codeme.springcloud.payment.service.PaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/3/16 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 * Testing Spring MVC Web Controllers with @WebMvcTest
 * https://reflectoring.io/spring-boot-web-controller-test/
 * @WebMvcTest controllers 参数将限定 spring 上下文仅初始 PaymentController
 * 而不是所有的 Controller（减少测试的复杂度及相关依赖）。
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PaymentController.class)
class TestPaymentController {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private PaymentService paymentService;

    @Test
    public void getPaymentByIdWhenValidInputThenReturns200() throws Exception {
        // Verifying HTTP Request Matching
        assertThat(paymentService).isNotNull();
    }
}
