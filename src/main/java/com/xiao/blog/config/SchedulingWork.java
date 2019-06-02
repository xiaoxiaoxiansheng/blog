package com.xiao.blog.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @ProjectName: blog
 * @ClassName: SchedulingWork
 * @Description:
 * @Date 2019/6/2/002 21:33
 * @Author: liujia
 * @Version: 1.0
 */
@Component
public class SchedulingWork {
    private static final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

    /**
    * @Description : 定时3秒执行一次
    * @Author      : liujia
    * @date        : 2019/6/2/002
    * @Param       :
    * @return      :
    */
    @Scheduled(fixedDelay = 3000)
    public void doWork(){
        System.out.println("liujia 执行: i love you " + sf.format(new Date()) + ".");
    }
}
