package com.xiao.blog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @Auther: liuj
 * @Date: 2019/5/30 18:11
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbc(){
        String sql = "select * from user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list.toString());
    }
}
