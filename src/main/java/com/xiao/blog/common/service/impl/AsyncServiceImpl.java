package com.xiao.blog.common.service.impl;

import com.xiao.blog.common.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Auther: liuj
 * @Date: 2019/6/4 09:58
 * @Description:
 */
@Service
public class AsyncServiceImpl implements AsyncService {
    @Async
    @Override
    public void test1() {
        System.out.println("test1执行。。。。。。。。。。。");
    }

    @Async
    @Override
    public void test2() {
        System.out.println("test2执行。。。。。。。。。。。");
    }
}
