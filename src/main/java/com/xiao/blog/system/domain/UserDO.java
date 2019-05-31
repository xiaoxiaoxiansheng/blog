package com.xiao.blog.system.domain;

import java.io.Serializable;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 11:43
 * @Description:
 */
public class UserDO implements Serializable {
   private int id;
   private String email;
   private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
