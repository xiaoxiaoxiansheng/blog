package com.xiao.blog.system.service.impl;

import com.xiao.blog.system.dao.UserDao;
import com.xiao.blog.system.domain.UserDO;
import com.xiao.blog.system.mapper.UserMapper;
import com.xiao.blog.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 12:56
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDO selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public List<UserDO> list(Map<String, Object> map) {
        return userDao.list(map);
    }

//    @Override
//    public UserDO selectById(long id) {
//        return userDao.selectById(id);
//    }
//
//    @Transactional
//    public int updateById(UserDO userDO){
//        int num = userMapper.updateById(userDO);
//        //测试事务控制
////        int i = 1/0;
//
//        return num;
//    }
}
