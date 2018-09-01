package com.netty4.server.controller;

import com.netty4.server.conf.jwt.JwtHelper;
import com.netty4.server.conf.jwt.JwtProperties;
import com.netty4.server.entity.SysUser;
import com.netty4.server.entity.qo.LoginQO;
import com.netty4.server.service.SysUserService;
import com.netty4.server.util.Errors;
import com.netty4.server.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "用户模块", basePath = "/sys/user", description = "用户模块相关接口")
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private JwtProperties jwtProperties;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public Object register(@RequestBody @Valid LoginQO login) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(login, sysUser);
        sysUserService.add(sysUser);
        return Result.build(Errors.SUCCESS);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Object login(@RequestBody @Valid LoginQO login) {
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
        String jwt = JwtHelper.createJWT(user, jwtProperties);
        return Result.build(Errors.SUCCESS).setData(jwt);
    }

    @ApiOperation(value = "用户登出")
    @PostMapping("/logout")
    public Object logout(Long id) {
        return Result.build(Errors.SUCCESS).setData("登出成功");
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    public Object getUser(@RequestParam(value = "id") Long id) {
        SysUser user = sysUserService.getSysUserByPrimaryKey(id);
        return Result.build(Errors.SUCCESS).setData(user);
    }


}
