package com.zln.personal.response;

import com.zln.personal.enums.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ErrorResult {

    /**
     * 异常状态码
     */
    private Integer status;

    /**
     * 用户看得见的异常，例如 用户名重复！！
     */
    private String message;

    /**
     * 异常的名字
     */
    private String exception;

    /**
     * 对异常提示语进行封装
     */
    public static ErrorResult fail(ResultCode resultCode, Throwable e, String message) {
        ErrorResult result = ErrorResult.fail(resultCode, e);
        result.setMessage(message);
        return result;
    }

    /**
     * 对异常枚举进行封装
     */
    public static ErrorResult fail(ResultCode resultCode, Throwable e){
        ErrorResult result = new ErrorResult();
        result.setMessage(resultCode.message());
        result.setStatus(resultCode.code());
        result.setException(e.getClass().getName());
        return result;
    }
}
