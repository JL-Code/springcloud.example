package com.codeme.springcloud.payment.controller;

import com.codeme.springcloud.payment.service.impl.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/3/17 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@WebMvcTest(WebTestController.class)
public class TestWebTestController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GreetingService greetingService;

    @Test
    public void testWhenValidInputThenReturns200() throws Exception {
        when(greetingService.greet()).thenReturn("你好，Mock");
        mockMvc.perform(get("/web-test/test")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("你好，Mock")));
    }
}
