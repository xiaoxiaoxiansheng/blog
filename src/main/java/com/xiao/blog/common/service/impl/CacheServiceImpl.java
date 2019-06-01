package com.xiao.blog.common.service.impl;

import com.xiao.blog.common.service.CacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Auther: liuj
 * @Date: 2019/6/1 10:26
 * @Description:
 */
@Service("cacheService")
public class CacheServiceImpl implements CacheService {

    /**
     * @Description:如果缓存中有，则直接走缓存，如果没有则执行方法，方法的返回值作为缓存
     * @auther: liuj
     * @date: 2019/6/1 10:28
     * @return:
     */
    @Cacheable(value = "cache-test", key = "'getName:' + #p0")
    @Override
    public String getName(long id) {
        System.out.println("等待3秒。。。。。。");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return id + ":name";
    }

    /**
     * @Description:将结果放入缓存
     * @auther: liuj
     * @date: 2019/6/1 10:31
     * @return:
     */
    @CachePut(value = "cache-test", key = "'getName:' + #p0")
    @Override
    public String updateName(long id) {
        System.out.println("更新名称。。。。。");
        return id + ":nickname";
    }

    /**
     * @Description:删除缓存
     * @auther: liuj
     * @date: 2019/6/1 10:33
     * @return:
     */
    @CacheEvict(value = "cache-test", key="'getName:' + #p0")
    @Override
    public void deleteName(long id) {
        System.out.println("删除缓存。。。。");
    }
}
