/*
 * FileName: Detect.java
 * Author:   Arshle
 * Date:     2018年01月12日
 * Description: 检测实体类
 */
package com.chezhibao.boss.entity;

import java.io.Serializable;

/**
 * 〈检测实体类〉<br>
 * 〈检测各项工程实体类〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public class Detect implements Serializable {

    private static final long serialVersionUID = 2965902338409473204L;
    /**
     * 检测单ID
     */
    private long id;
    /**
     * 地区
     */
    private int region;
    /**
     * 工程师ID
     */
    private long engineerId;
    /**
     * 工程师名称
     */
    private String engineerName;
    /**
     * 地址
     */
    private String address;
    /**
     * 状态
     */
    private int status;
    /**
     * 客户ID
     */
    private long customerId;
    /**
     * Getters、Setters
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public long getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(long engineerId) {
        this.engineerId = engineerId;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
