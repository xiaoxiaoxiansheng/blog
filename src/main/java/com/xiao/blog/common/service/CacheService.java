package com.xiao.blog.common.service;

/**
 * @Auther: liuj
 * @Date: 2019/6/1 10:24
 * @Description:springboot缓存
 */
public interface CacheService {
    String getName(long id);
    String updateName(long id);
    void deleteName(long id);
}
