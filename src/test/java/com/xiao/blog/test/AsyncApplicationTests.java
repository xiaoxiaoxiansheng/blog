package com.xiao.blog.test;

import com.xiao.blog.common.service.AsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: liuj
 * @Date: 2019/6/4 10:02
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncApplicationTests {
    @Autowired
    private AsyncService asyncService;

    /**
     * @Description:异步方法测试
     * @auther: liuj
     * @date: 2019/6/4 10:06
     * @return:
     */
    @Test
    public void testAsync(){

        for(int i=0; i<10; i++){
            asyncService.test1();
            asyncService.test2();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
