package com.xiao.blog.common.service.impl;

import com.xiao.blog.common.dao.LogDao;
import com.xiao.blog.common.domain.LogDO;
import com.xiao.blog.common.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: blog
 * @ClassName: LogServiceImpl
 * @Description:
 * @Date 2019/6/7/007 19:13
 * @Author: liujia
 * @Version: 1.0
 */
@Service("LogService")
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;
    /**
    * @Description :切面日志新增
    * @Author      : liujia
    * @date        : 2019/6/7/007
    * @Param       :
    * @return      :
    */
    @Async
    @Override
    public void save(LogDO logDO) {
        logDao.save(logDO);
    }
}
