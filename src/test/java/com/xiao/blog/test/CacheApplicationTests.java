package com.xiao.blog.test;

import com.xiao.blog.common.service.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: liuj
 * @Date: 2019/6/1 10:38
 * @Description:缓存测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {

    @Autowired
    private CacheService cacheService;

    @Test
    public void contextLoad() {
        System.out.println("getName id 88 : String " + cacheService.getName(88L));
        System.out.println("getName 缓存 id 88 : String " + cacheService.getName(88L));
        System.out.println("updateName  id 88 : String " + cacheService.updateName(88L));
        System.out.println("getName 缓存 id 88 : String " + cacheService.getName(88L));
        cacheService.deleteName(88L);
        System.out.println("getName 缓存 id 88 : String " + cacheService.getName(88L));



    }
}
