package com.codeme.springcloud.ribbonorder.handler;

import com.netflix.client.ClientException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/7/6 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception e) {
        e.printStackTrace();
        if (e instanceof com.netflix.client.ClientException) {
            ClientException ce = (ClientException) e;
            return ResponseEntity.status(500).body(new RESTEntity(ce.getErrorMessage(), ce.getErrorCode()));
        }
        return ResponseEntity.notFound().build();
    }
}
