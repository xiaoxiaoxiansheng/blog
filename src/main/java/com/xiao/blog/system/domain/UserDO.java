package com.xiao.blog.system.domain;

import java.io.Serializable;

/**
 * @Auther: liuj
 * @Date: 2019/5/31 11:43
 * @Description:
 */
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long userId;
    private String username;
    private String name;
    private String password;
    private long deptId;
    private String email;
    private String mobile;
    private long status;
    private long userIdCreate;
    private java.sql.Timestamp gmtCreate;
    private java.sql.Timestamp gmtModified;
    private long sex;
    private java.sql.Timestamp birth;
    private long picId;
    private String liveAddress;
    private String hobby;
    private String province;
    private String city;
    private String district;


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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }


    public long getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(long userIdCreate) {
        this.userIdCreate = userIdCreate;
    }


    public java.sql.Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(java.sql.Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }


    public java.sql.Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(java.sql.Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }


    public long getSex() {
        return sex;
    }

    public void setSex(long sex) {
        this.sex = sex;
    }


    public java.sql.Timestamp getBirth() {
        return birth;
    }

    public void setBirth(java.sql.Timestamp birth) {
        this.birth = birth;
    }


    public long getPicId() {
        return picId;
    }

    public void setPicId(long picId) {
        this.picId = picId;
    }


    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }


    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
