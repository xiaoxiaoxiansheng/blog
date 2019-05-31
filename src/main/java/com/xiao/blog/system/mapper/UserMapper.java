package com.xiao.blog.system.mapper;

import com.xiao.blog.system.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 11:53
 * @Description:
 */
@Repository
@Mapper
public interface UserMapper {
    UserDO selectById(long id);
}
