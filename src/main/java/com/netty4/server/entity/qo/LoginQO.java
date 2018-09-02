package com.netty4.server.entity.qo;


import javax.validation.constraints.NotEmpty;

public class LoginQO {

    @NotEmpty(message = "请填写用户名或手机号码")
    private String loginName;


    @NotEmpty(message = "请填写登录密码")
    private String password;



    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
