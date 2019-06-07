package com.xiao.blog.test;

import com.xiao.blog.system.dao.UserDao;
import com.xiao.blog.system.domain.UserDO;
import com.xiao.blog.system.mapper.UserMapper;
import com.xiao.blog.system.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.zip.DeflaterOutputStream;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 12:47
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Autowired
//    UserMapper userMapper;
    UserDao userDao;
    @Autowired
    UserService userService;

}
