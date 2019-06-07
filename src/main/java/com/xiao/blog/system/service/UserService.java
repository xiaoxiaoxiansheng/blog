package com.xiao.blog.system.service;

import com.xiao.blog.system.domain.UserDO;

import java.util.List;
import java.util.Map;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 12:56
 * @Description:
 */
public interface UserService {
//    UserDO selectById(long id);
    UserDO selectByUsername(String username);
    List<UserDO> list(Map<String, Object> map);
//    int updateById(UserDO userDO);
}
