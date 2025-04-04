package com.msb.api.common;

import com.msb.api.code.SystemCode;

public class ResponseResultFactory<T> {
    /**
     * 构建一个通用的成功的返回结果
     * @return
     */
    public static ResponseResult buildResponseResult() {
        return new ResponseResult<>(SystemCode.TRAFFIC_SYSTEM_SUCCESS);
    }
    public static ResponseResult buildResponseResult(String resultCode) {
        return new ResponseResult(resultCode);
    }
    public static ResponseResult buildResponseResult(String resultCode, String resultMsg) {
        return new ResponseResult<>(resultCode, resultMsg);
    }
    public static <T> ResponseResult buildResponseResult(String resultCode, T result) {
        return new ResponseResult<>(resultCode, result);
    }
    public static <T> ResponseResult buildResponseResult(String resultCode, String resultMsg, T result) {
        return new ResponseResult<>(resultCode, resultMsg, result);
    }
}
