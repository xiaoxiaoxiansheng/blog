package com.xiao.blog.test;

import com.xiao.blog.system.domain.UserDO;
import com.xiao.blog.system.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 12:47
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {

    @Autowired
    public UserMapper userMapper;

    @Test
    public void testMybatis(){
        UserDO userDO = userMapper.selectById(1001);
        System.out.println(userDO.toString());
    }
}
