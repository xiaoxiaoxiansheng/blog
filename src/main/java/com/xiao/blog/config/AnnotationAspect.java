package com.xiao.blog.config;

import com.alibaba.druid.support.json.JSONUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * @ProjectName: blog
 * @ClassName: AnnotationAspect
 * @Description:
 * @Date 2019/6/2/002 20:29
 * @Author: liujia
 * @Version: 1.0
 */
@Aspect
@Component
public class AnnotationAspect {
    Logger logger = LoggerFactory.getLogger(AnnotationAspect.class);

    @Pointcut(value = "@annotation(print)")
    public void annotationPointcut(Print print){
    }

    @Around("annotationPointcut(print)")
    public String around(ProceedingJoinPoint joinPoint, Print print){
        Signature sig =  joinPoint.getSignature();
        String method = joinPoint.getTarget().getClass().getName() + "." + sig.getName();

        Object[] args = joinPoint.getArgs();
//        String params = JSONUtils.toJSONString(args);

        logger.info("返回结果 ：" + method + ":" + args.toString());
        return args.toString();
    }
}
