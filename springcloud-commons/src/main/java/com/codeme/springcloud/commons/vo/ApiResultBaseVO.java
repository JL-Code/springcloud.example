package com.codeme.springcloud.commons.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResultBaseVO {
    /**
     * 错误码
     */
    private Integer errcode;
    /**
     * 错误描述文本
     */
    private String errmsg;

    /**
     * 错误信息
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String error;


    /**
     * 错误堆栈信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> debug;
}
