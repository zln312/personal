package com.zln.personal.response;

import com.zln.personal.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> {

    /**
     * 1.status状态值：代表本次请求response的状态结果
     */
    private Integer code;
    /**
     * 2.response描述：对本次状态码的描述
     */
    private String message;
    /**
     * 3.data数据：本次返回的数据
     */
    private T data;

    /**
     * 成功，创建ResResult: 没data数据
     */
    public static Result suc() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    /**
     * 成功，创建ResResult: 有data数据
     */
    public static Result suc(Object data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 失败，指定status、desc
     */
    public static Result fail(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }


    /**
     * 失败，指定ResultCode枚举
     */
    public static Result fail(ResultCode resultCode){
        Result result = new Result();
        result.setResultCode(resultCode);
        return result;
    }

    private void setResultCode(ResultCode code) {
        this.code = code.code();
        this.message = code.message();
    }
}
