package com.netty4.server.service;


import com.netty4.server.entity.SysUser;
import com.netty4.server.entity.qo.LoginQO;
import com.netty4.server.mapper.SysUserMapper;
import com.netty4.server.util.Errors;
import com.netty4.server.util.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    public int add(SysUser sysUser) {
        return sysUserMapper.insert(sysUser);
    }

    public int logicalDelete(Long pkId) {
        return sysUserMapper.logicalDeleteByPrimaryKey(pkId);

    }

    public int updateSelective(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    public SysUser getSysUserByPrimaryKey(Long pkId) {

        return sysUserMapper.selectByPrimaryKeyWithLogicalDelete(pkId, false);
    }

    public SysUser getSysUserByLoginName(String loginName) {
        return sysUserMapper.selectByLoginName(loginName);
    }

    public SysUser getSysUserByMobile(String mobile) {
        return sysUserMapper.selectByMobile(mobile);
    }


    /**
     * 注册用户
     */
    public Object register(LoginQO login) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(login, sysUser);
        sysUser.setDeleted(false);
        add(sysUser);
        return Result.build(Errors.SUCCESS);
    }


    public SysUser login(LoginQO login) {
        //先匹配手机号码，在匹配用户名
        SysUser user = getSysUserByMobile(login.getLoginName());
        if (null == user) {
            user = getSysUserByLoginName(login.getLoginName());
        }
        return user;

    }

}
