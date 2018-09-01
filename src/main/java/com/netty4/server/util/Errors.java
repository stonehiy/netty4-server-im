package com.netty4.server.util;

import java.io.Serializable;

/**
 * @author M_Sir
 */

public enum Errors implements Serializable {
    /**
     * 访问接口失败
     */
    FAILURE(-1,"FAIL"),
    SUCCESS(0,"SUCCESS"),
    TOKEN_EXPIRE(1,"TOKEN已过期,请重新登录"),
    USER_NOT_EXIST(2,"用户不存在"),
    PASSWORD_ERROR(3,"用户名或密码错误"),
    UNAUTHORIZED(4,"接口没有权限访问"),
    EMPLOYEE_NOT_EXIST_FROZEN(5,"用户不存在或已被停用"),
    PARAMETER_ERROR(400,"参数异常"),
    TOEKN_UNAUTHORIZED(401,"401 Unauthorized"),
       ;
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    Errors(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
