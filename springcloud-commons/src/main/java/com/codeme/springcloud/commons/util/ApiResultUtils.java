package com.codeme.springcloud.commons.util;

import com.codeme.springcloud.commons.vo.ApiResultBaseVO;
import lombok.experimental.var;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

public class ApiResultUtils {

    public static HashMap<String, Object> buildResult(int errCode, String errMsg) {
        HashMap<String, Object> response = new HashMap<>(16);
        response.put("errmsg", errMsg);
        response.put("errcode", errCode);
        return response;
    }

    public static HashMap<String, Object> buildResult(int errCode, String errMsg, Throwable throwable) {
        HashMap<String, Object> response = new HashMap<>(16);
        response.put("errmsg", errMsg);
        response.put("errcode", errCode);
        response.put("debug", getStackTrace(throwable));
        return response;
    }

    public static HashMap<String, Object> buildResult(Object data, Throwable throwable) {
        HashMap<String, Object> response = new HashMap<>(16);
        response.put("data", data);
        response.put("debug", getStackTrace(throwable));
        return response;
    }

    public static ApiResultBaseVO buildApiResult(int errCode, String errMsg, Throwable throwable) {
        var response = new ApiResultBaseVO();
        response.setErrcode(errCode);
        response.setErrmsg(errMsg);
        response.setError(getStackTrace(throwable));
        return response;
    }

    /**
     * 获取堆栈错误信息
     *
     * @param throwable 异常对象
     * @return
     */
    private static String getStackTrace(Throwable throwable) {

        if (throwable == null) {
            return "";
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            throwable.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
