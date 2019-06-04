package com.xiao.blog.common.controller;

import com.xiao.blog.common.utils.ShiroUtils;
import com.xiao.blog.system.domain.UserDO;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

/**
 * @ProjectName: blog
 * @ClassName: BaseController
 * @Description: 父controller
 * @Date 2019/6/4/004 21:39
 * @Author: liujia
 * @Version: 1.0
 */
@Controller
public class BaseController {
    public Subject getSubject(){
        return ShiroUtils.getSubject();
    }

    public UserDO getUser(){
        return ShiroUtils.getUser();
    }

    public Long getUserId(){
        return getUser().getUserId();
    }

    public String getUsername(){
        return getUser().getUsername();
    }
}
