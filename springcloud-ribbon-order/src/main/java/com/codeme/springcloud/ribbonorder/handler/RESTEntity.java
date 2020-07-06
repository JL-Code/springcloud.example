package com.codeme.springcloud.ribbonorder.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2020/7/6 </p>
 *
 * @author <a href="mailto:jiangy@highzap.com" rel="nofollow">蒋勇</a>
 * @version v1.0
 */
@Data
@AllArgsConstructor
public class RESTEntity {
    private String errmsg;
    private int errcode;
}
