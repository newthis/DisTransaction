/*
 * FileName: Auction.java
 * Author:   Arshle
 * Date:     2018年01月13日
 * Description: 竞拍实体类
 */
package com.chezhibao.aucs.entity;

import java.io.Serializable;

/**
 * 〈竞拍实体类〉<br>
 * 〈竞拍实体类〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public class Auction implements Serializable{

    private static final long serialVersionUID = -1820622635349969411L;
    /**
     * 竞拍ID
     */
    private long id;
    /**
     * 订单编号
     */
    private long orderId;
    /**
     * 场次名称
     */
    private String screenName;
    /**
     * 地区
     */
    private int region;
    /**
     * 状态
     */
    private int status;
    /**
     * Getters、Setters
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
