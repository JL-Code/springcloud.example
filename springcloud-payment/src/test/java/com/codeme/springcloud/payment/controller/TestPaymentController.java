package com.codeme.springcloud.payment.controller;

import com.codeme.springcloud.payment.entities.Payment;
import com.codeme.springcloud.payment.service.impl.PaymentServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(PaymentController.class)
class TestPaymentController {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PaymentServiceImpl paymentService;

    @Test
    public void getPaymentByIdWhenValidInputThenReturns200() throws Exception {
        // Verifying HTTP Request Matching
        // 参数捕获器 ArgumentCaptor
        ArgumentCaptor<Payment> paymentCaptor = ArgumentCaptor.forClass(Payment.class);
        verify(paymentService, times(1))
                .getPaymentById(110L);
//        assertThat(userCaptor.getValue().getName()).isEqualTo("Zaphod");
//        assertThat(userCaptor.getValue().getEmail()).isEqualTo("zaphod@galaxy.net");
    }
}
