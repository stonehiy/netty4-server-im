package com.netty4.server.service;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int add(User user) {

        return userMapper.insert(user);
    }

    public int delete(Long pkId) {
        return userMapper.deleteByPrimaryKey(pkId);

    }
}
