package com.netty4.server.entity.qo;


import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * GroupSequence注解是用来指定验证顺序
 */
@GroupSequence({LoginQO.First.class, LoginQO.Second.class,LoginQO.class})
public class LoginQO implements Serializable{
    public static class First{}
    public static class Second{}

    @NotEmpty(message = "请填写用户名或手机号码" ,groups = {First.class})
    private String loginName;


    @NotEmpty(message = "请填写登录密码",groups = {Second.class})
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
