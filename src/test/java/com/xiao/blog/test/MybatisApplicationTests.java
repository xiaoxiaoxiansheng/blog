package com.xiao.blog.test;

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
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void testMybatis(){
        UserDO userDO = userMapper.selectById(1001);
        System.out.println(userDO.toString());
    }

    @Test
    public void testMybatisInsert(){
        UserDO userDO = new UserDO();
//        userDO.setId(1003);
        userDO.setEmail("666666@qq.com");
        userDO.setName("乌鸦");
        int num = userMapper.save(userDO);
        System.out.println("===================="+ num);
    }

    @Test
    public void testUpdate(){
        UserDO userDO = userService.selectById(1002);
        System.out.println(userDO.toString());
        userDO.setName("liujiang");
        userDO.setEmail("815130927@qq.com");

        int num = userService.updateById(userDO);

        System.out.println(num);

    }
}
