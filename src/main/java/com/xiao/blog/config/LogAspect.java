package com.xiao.blog.config;

//import com.fasterxml.jackson.databind.util.JSONPObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ProjectName: blog
 * @ClassName: LogAspect
 * @Description:
 * @Date 2019/6/2/002 16:49
 * @Author: liujia
 * @Version: 1.0
 */
@Aspect
@Component
//lombok日志
//@SLF4J
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.xiao.blog..*.*(..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void printParam(JoinPoint joinPoint){
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        logger.info("`````````````````Method :" + request.getMethod());
//        logger.info("`````````````````Path :" + request.getContextPath());
//        logger.info("`````````````````ip :" + request.getRemoteAddr());

        //获取请求
        Signature sig = joinPoint.getSignature();
        String method = joinPoint.getTarget().getClass().getName() + "." + sig.getName();

        Object[] args = joinPoint.getArgs();
//        String params = JSONPObject.toJSONString(args);
        logger.info(Arrays.toString(args));
        System.out.println(args.toString());
    }

    @AfterReturning(returning = "ret", pointcut = "pointcut()")
    public void doAfterReturning(Object ret){
        logger.info("response : " + ret);
    }


}
