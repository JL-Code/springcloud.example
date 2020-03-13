package com.codeme.springcloud.commons.controller;

import com.codeme.springcloud.commons.util.ApiResultUtils;
import lombok.experimental.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiControllerBase {

    // region 通用的响应方法

    /**
     * Creates an ResponseEntity (200 OK).
     *
     * @return
     */
    @ResponseBody
    public ResponseEntity ok() {
        return ResponseEntity.ok().body(null);
    }

    /**
     * Creates an ResponseEntity (200 OK) with the specified values.
     *
     * @param content The content value to negotiate and format in the entity body.
     * @param <T>     The type of content in the entity body.
     * @return
     */
    @ResponseBody
    public <T> ResponseEntity<T> ok(T content) {
        return ResponseEntity.ok(content);
    }

    /**
     * 返回一个创建成功的响应
     *
     * @param content 响应内容
     * @param <T>
     * @return
     */
    @ResponseBody
    public <T> ResponseEntity<T> created(T content) {
        return ResponseEntity.status(201).body(content);
    }

    /**
     * Creates an ResponseEntity (404 Not Found).
     *
     * @param errcode 错误码
     * @param errmsg  错误文本消息
     * @return
     */
    @ResponseBody
    public ResponseEntity notFound(int errcode, String errmsg) {
        var response = ApiResultUtils.buildResult(errcode, errmsg);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ResponseBody
    public ResponseEntity notFound(String errmsg) {
        var response = ApiResultUtils.buildResult(404, errmsg);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Creates a ResponseEntity (400 Bad Request).
     *
     * @param errcode 错误码
     * @param errmsg  错误文本消息
     * @return
     */
    @ResponseBody
    public ResponseEntity badRequest(int errcode, String errmsg) {
        var response = ApiResultUtils.buildResult(errcode, errmsg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Creates a ResponseEntity (400 Bad Request).
     *
     * @param errmsg 错误文本消息
     * @return
     */
    @ResponseBody
    public ResponseEntity badRequest(String errmsg) {
        var response = ApiResultUtils.buildResult(HttpStatus.BAD_REQUEST.value(), errmsg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // endregion

}
