package com.xiao.blog.system.dao;

import com.xiao.blog.system.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: blog
 * @ClassName: UserDao
 * @Description:
 * @Date 2019/6/6/006 23:08
 * @Author: liujia
 * @Version: 1.0
 */
@Repository
@Mapper
public interface UserDao {
//    UserDO selectById(long id);
//
//    int save(UserDO userDO);
//
//    //    @Update("update user set name = #{name}, email = #{email} where id = #{id}")
//    int updateById(UserDO userDO);

    List<UserDO> list(Map<String, Object> map);

    UserDO selectByUsername(String username);
}
