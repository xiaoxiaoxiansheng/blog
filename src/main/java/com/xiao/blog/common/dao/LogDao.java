package com.xiao.blog.common.dao;

import com.xiao.blog.common.domain.LogDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: blog
 * @ClassName: LogDao
 * @Description:
 * @Date 2019/6/7/007 19:12
 * @Author: liujia
 * @Version: 1.0
 */
@Repository
@Mapper
public interface LogDao{
    int save(LogDO logDO);
}
