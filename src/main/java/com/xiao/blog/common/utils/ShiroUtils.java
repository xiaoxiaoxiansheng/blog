package com.xiao.blog.common.utils;

import com.xiao.blog.system.domain.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.List;

/**
 * @ProjectName: blog
 * @ClassName: ShiroUtils
 * @Description:
 * @Date 2019/6/4/004 21:41
 * @Author: liujia
 * @Version: 1.0
 */
public class ShiroUtils {
    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static UserDO getUser(){
        Object object = getSubject().getPrincipal();
        return (UserDO) object;
    }

    public static Long getUserId(){
        return getUser().getUserId();
    }

    public static void logout(){
        getSubject().logout();
    }
}
