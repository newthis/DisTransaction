/*
 * FileName: BizService.java
 * Author:   Arshle
 * Date:     2018年01月12日
 * Description: 业务整合接口
 */
package com.chezhibao.api;

import com.chezhibao.aucs.entity.Auction;
import com.chezhibao.boss.entity.Detect;
import com.chezhibao.crm.entity.Customer;

/**
 * 〈业务整合接口〉<br>
 * 〈业务整合分布式事务接口〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public interface BizApi {
    /**
     * 执行业务
     * @param customer 客户
     * @param detect 检测
     */
    void invoke(Customer customer, Detect detect, Auction auction);
}
