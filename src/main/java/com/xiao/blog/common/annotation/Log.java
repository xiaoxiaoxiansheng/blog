package com.xiao.blog.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: blog
 * @ClassName: Log
 * @Description:
 * @Date 2019/6/7/007 17:48
 * @Author: liujia
 * @Version: 1.0
 */
//注解的作用目标
@Target(ElementType.METHOD)
//// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
