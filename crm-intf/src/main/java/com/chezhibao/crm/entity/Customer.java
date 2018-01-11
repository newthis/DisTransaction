/*
 * FileName: Customer.java
 * Author:   Arshle
 * Date:     2018年01月11日
 * Description: 客户实体类
 */
package com.chezhibao.crm.entity;

import java.io.Serializable;

/**
 * 〈客户实体类〉<br>
 * 〈客户实体类〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 2709081927349406972L;
    /**
     * 客户ID
     */
    private long id;
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 客户性别
     */
    private int sex;
    /**
     * 客户地区
     */
    private int region;
    /**
     * 客户手机号
     */
    private String mobile;
    /**
     * 客户邮箱
     */
    private String email;
    /**
     * 客服ID
     */
    private long serviceId;
    /**
     * 客服名称
     */
    private String serviceName;
    /**
     * Getters、Setters
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
