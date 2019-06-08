package com.xiao.blog.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: blog
 * @ClassName: LogDO
 * @Description: 日志实体类
 * @Date 2019/6/7/007 17:45
 * @Author: liujia
 * @Version: 1.0
 */
public class LogDO implements Serializable {
    private long id;
    private long userId;
    private String username;
    private String operation;
    private long time;
    private String method;
    private String params;
    private String ip;
    private Date gmtCreate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }


    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

}
