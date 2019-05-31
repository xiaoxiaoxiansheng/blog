package com.xiao.blog.system.mapper;

import com.xiao.blog.system.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
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

    int save(UserDO userDO);

//    @Update("update user set name = #{name}, email = #{email} where id = #{id}")
    int updateById(UserDO userDO);
}
