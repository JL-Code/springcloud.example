package com.codeme.springcloud.commons.controller;

import com.codeme.springcloud.commons.util.ApiResultUtils;
import com.codeme.springcloud.commons.vo.ApiResultBaseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;

import java.util.HashMap;

public class ApiControllerBase {

    public ApiControllerBase() {
    }

    // region 通用的响应方法

    /**
     * Creates an ResponseEntity (200 OK).
     *
     * @return
     */

    public ResponseEntity ok() {
        return ok(null);
    }

    /**
     * Creates an ResponseEntity (200 OK) with the specified values.
     *
     * @param content The content value to negotiate and format in the entity body.
     * @param <T>     The type of content in the entity body.
     * @return
     */

    public <T> ResponseEntity<T> ok(@Nullable T content) {
        return ResponseEntity.ok(content);
    }

    /**
     * 返回一个创建成功的响应
     *
     * @param content 响应内容
     * @param <T>
     * @return
     */

    public <T> ResponseEntity<T> created(T content) {
        return ResponseEntity.status(201).body(content);
    }

    /**
     * Creates an ResponseEntity (404 Not Found).
     *
     * @param errcode 错误码
     * @param errmsg  文本描述消息
     * @return
     */

    public ResponseEntity notFound(int errcode, String errmsg) {
        HashMap<String, Object> response = ApiResultUtils.buildResult(errcode, errmsg);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Creates an ResponseEntity (404 Not Found).
     * @param errmsg
     * @return
     */
    public ResponseEntity notFound(String errmsg) {
        HashMap<String, Object> response = ApiResultUtils.buildResult(400404, errmsg);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Creates a ResponseEntity (400 Bad Request).
     *
     * @param errcode 错误码
     * @param errmsg  文本描述消息
     * @return
     */

    public ResponseEntity badRequest(int errcode, String errmsg) {
        HashMap<String, Object> response = ApiResultUtils.buildResult(errcode, errmsg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Creates a ResponseEntity (400 Bad Request).
     *
     * @param errmsg 文本描述消息
     * @return
     */

    public ResponseEntity<ApiResultBaseVO> badRequest(String errmsg) {
        ApiResultBaseVO response = ApiResultUtils.buildApiResult(400400, errmsg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     *
     * @param errcode 错误码
     * @param errmsg 文本描述消息
     * @return
     */
    public ResponseEntity fail(int errcode, String errmsg) {
        ApiResultBaseVO response = ApiResultUtils.buildApiResult(errcode, errmsg);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // endregion

}
