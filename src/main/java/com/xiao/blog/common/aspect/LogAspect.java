package com.xiao.blog.common.aspect;

//import com.fasterxml.jackson.databind.util.JSONPObject;
import com.alibaba.fastjson.JSONObject;
import com.xiao.blog.common.annotation.Log;
import com.xiao.blog.common.domain.LogDO;
import com.xiao.blog.common.service.LogService;
import com.xiao.blog.common.utils.HttpContextUtils;
import com.xiao.blog.common.utils.IPUtils;
import com.xiao.blog.common.utils.JSONUtils;
import com.xiao.blog.common.utils.ShiroUtils;
import com.xiao.blog.system.domain.UserDO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    private LogService logService;

    /**
    * @Description : Log注解添加切面
    * @Author      : liujia
    * @date        : 2019/6/7/007
    * @Param       : 
    * @return      : 
    */
    @Pointcut("@annotation(com.xiao.blog.common.annotation.Log)")
    public void logPointcut(){

    }

    @Around("logPointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = joinPoint.proceed();
        //执行时长
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveLog(joinPoint, time);

        return result;
    }

    void saveLog(ProceedingJoinPoint joinPoint, long time) throws Throwable{
        LogDO logDO = new LogDO();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Log syslog = method.getAnnotation(Log.class);
        //注解内容value
        if(syslog != null){
            logDO.setOperation(syslog.value());
        }
        //请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //请求的方法名
        String methodName = signature.getName();
        logDO.setMethod(className+ "." + methodName+ "()");
        //获取请求参数，并转换为json
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        Object[] args = joinPoint.getArgs();
        String params = "";
        Map<String, Object> usernameMap = new HashMap<>();
        usernameMap.put("username", args[0].toString());
        params = JSONUtils.beanToJson(usernameMap);
        logDO.setParams(params);
        UserDO curr_user = ShiroUtils.getUser();
        if(curr_user == null){
            logDO.setUserId(-1);
            if(params != null && !"".equals(params)){
                logDO.setUsername(params.toString());
            }else{
                logDO.setUsername("该用户名信息为空");
            }
        }else{
            //userID
            logDO.setUserId(curr_user.getUserId());
            //username
            logDO.setUsername(curr_user.getUsername());
        }
        //time,访问时长
        logDO.setTime(time);
        //ip 访问IP地址
//        logDO.setIp(request.getRemoteAddr());
        logDO.setIp(IPUtils.getIPAddr(request));
        //gmt_create
        logDO.setGmtCreate(new Date());
        //保存系统日志
        logService.save(logDO);
    }



//    @Before("pointcut()")
//    public void printParam(JoinPoint joinPoint){
////        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
////        HttpServletRequest request = attributes.getRequest();
////
////        logger.info("`````````````````Method :" + request.getMethod());
////        logger.info("`````````````````Path :" + request.getContextPath());
////        logger.info("`````````````````ip :" + request.getRemoteAddr());
//
//        //获取请求
//        Signature sig = joinPoint.getSignature();
//        String method = joinPoint.getTarget().getClass().getName() + "." + sig.getName();
//
//        Object[] args = joinPoint.getArgs();
////        String params = JSONPObject.toJSONString(args);
//        logger.info(Arrays.toString(args));
//        System.out.println(args.toString());
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "pointcut()")
//    public void doAfterReturning(Object ret){
//        logger.info("response : " + ret);
//    }


}
