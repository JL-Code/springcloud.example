package com.codeme.springcloud.commons.openfeign;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

/**
 * <p>描述: Feign 错误解码器，处理 Feign 调用下游服务时报错的信息，统一封装，便于 GlobalExceptionAware 全局捕获。 </p>
 * <p>创建时间: 2020/7/6 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@Component
public class ExceptionErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        // TODO: 提取 response 中的 {errmsg:"",errcode:0} 信息，抛出 FeignResultException
        return null;
    }
}
