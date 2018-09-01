package com.netty4.server.util;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.BindingResult;

import java.io.Serializable;

/**
 * @author M_Sir
 */
@ApiModel(description = "返回响应数据")
public class Result<T> implements Serializable {

    @ApiModelProperty(value = "错误编号")
    private int code = 0;

    @ApiModelProperty(value = "错误信息")
    private String msg="成功";

    @ApiModelProperty(value = "是否成功")
    private boolean success = true;

    @ApiModelProperty(value = "返回对象")
    private T data;

    public static <T> Result<T> build(Errors errors){
        return new Result<T>().setCode(errors.getCode()).setMsg(errors.getMsg());
    }

    public static <T>  Result<T> build(BindingResult bindingResult){
        Result<T> result = new Result<>();
        StringBuilder sb = new StringBuilder();
        if(bindingResult.hasErrors()){
            result.setCode(Errors.FAILURE.getCode());
           bindingResult.getFieldErrors().forEach(fieldError -> sb.append("[").append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append("],"));
           String msg = sb.toString();
           result.setMsg(msg.substring(0,msg.length()-1));
        }
        return result;
    }


    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        if(code != 0){
            this.success = false;
        }
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }
}
