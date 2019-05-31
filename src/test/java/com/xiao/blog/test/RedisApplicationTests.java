package com.xiao.blog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 17:00
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * @Description:
     *     RedisTemplate和StringRedisTemplate是常用的模板
     *
     *     StringRedisTemplate是RedisTemplate<String, String>的子类，key和value序列化都是StringRedisSerializer，只能操作string类型
     *     RedisTemplate注入的时候如果使用@Autowired则不能使用泛型
     *     如果使用泛型可以使用@Resource注解进行注入（参考@Autowired和@Resource区别）
     *     如果想使用@Autowired注入并使用泛型，可以重新注册bean，第四步设置序列化也属于重新注册bean
     * @auther: liuj
     * @date: 2019/5/31 17:06
     * @return:
     */
    @Test
    public void contextLoads(){
        redisTemplate.opsForValue().set("test",100);
        int test = (int) redisTemplate.opsForValue().get("test");

        System.out.println(test);
    }
}
