package com.netty4.server.service;


import com.netty4.server.entity.SysUser;
import com.netty4.server.mapper.SysUserMapper;
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


}
