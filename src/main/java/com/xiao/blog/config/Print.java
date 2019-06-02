package com.xiao.blog.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: blog
 * @ClassName: Print
 * @Description:
 * @Date 2019/6/2/002 20:23
 * @Author: liujia
 * @Version: 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Print {
    String value() default "";
}
