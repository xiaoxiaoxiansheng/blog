package com.xiao.blog.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: blog
 * @ClassName: blogConfig
 * @Description:
 * @Date 2019/6/4/004 23:21
 * @Author: liujia
 * @Version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "xiao")
public class BlogConfig {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
