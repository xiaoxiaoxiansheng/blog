package com.xiao.blog.system.service.impl;

import com.xiao.blog.system.domain.UserDO;
import com.xiao.blog.system.mapper.UserMapper;
import com.xiao.blog.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 12:56
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO selectById(long id) {
        return userMapper.selectById(id);
    }

    @Transactional
    public int updateById(UserDO userDO){
        int num = userMapper.updateById(userDO);
        //测试事务控制
//        int i = 1/0;

        return num;
    }
}
