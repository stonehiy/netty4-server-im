package com.netty4.server.controller;

import com.netty4.server.entity.SysUser;
import com.netty4.server.entity.qo.LoginQO;
import com.netty4.server.service.SysUserService;
import com.netty4.server.util.Errors;
import com.netty4.server.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/User")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @PostMapping("/register")
    public Object register(@RequestBody SysUser sysUser) {
        sysUserService.add(sysUser);
        return Result.build(Errors.SUCCESS);
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginQO login) {
        //先匹配手机号码，在匹配用户名
        SysUser user = sysUserService.getSysUserByMobile(login.getLoginName());
        if (null == user) {
            user = sysUserService.getSysUserByLoginName(login.getLoginName());
            if (null == user) {
                return Result.build(Errors.USER_NOT_EXIST);
            }
        }

        if (!user.getPassword().equals(login.getPassword())) {
            Result.build(Errors.PASSWORD_ERROR);
        }
        return Result.build(Errors.SUCCESS).setData(user);
    }

    @PostMapping("/logout")
    public Object logout(Long id) {
        return Result.build(Errors.SUCCESS).setData("登出成功");
    }

    @GetMapping("/getUser")
    public Object getUser(@RequestParam(value = "id") Long id) {
        SysUser user = sysUserService.getSysUserByPrimaryKey(id);
        return Result.build(Errors.SUCCESS).setData(user);
    }


}
