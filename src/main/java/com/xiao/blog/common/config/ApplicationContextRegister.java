package com.xiao.blog.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: blog
 * @ClassName: ApplicationContextRegister
 * @Description:applicationContext注册配置bean
 * @Date 2019/6/6/006 21:34
 * @Author: liujia
 * @Version: 1.0
 */
@Component
public class ApplicationContextRegister implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(ApplicationContextRegister.class);
    private static ApplicationContext APPLICATION_CONTEXT;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("ApplicationContextRegister : ", applicationContext);
        APPLICATION_CONTEXT = applicationContext;
    }
    
    /**
    * @Description : 获取容器
    * @Author      : liujia
    * @date        : 2019/6/6/006
    * @Param       : 
    * @return      : 
    */
    public ApplicationContext getApplicationContext(){
        return APPLICATION_CONTEXT;
    }

    /**
    * @Description : 获取容器对象
    * @Author      : liujia
    * @date        : 2019/6/6/006
    * @Param       :
    * @return      :
    */
    public static <T> T getBean(Class<T> type){
        return APPLICATION_CONTEXT.getBean(type);
    }
}
