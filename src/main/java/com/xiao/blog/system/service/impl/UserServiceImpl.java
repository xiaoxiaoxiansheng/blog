package com.xiao.blog.system.service.impl;

import com.xiao.blog.system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 12:56
 * @Description:
 */
@Service("userService")
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;
}
