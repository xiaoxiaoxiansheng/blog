package com.xiao.blog.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: blog
 * @ClassName: HttpContextUtils
 * @Description:获取上下文信息HttpServletRequest
 * @Date 2019/6/7/007 18:55
 * @Author: liujia
 * @Version: 1.0
 */
public class HttpContextUtils {
    public static HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
