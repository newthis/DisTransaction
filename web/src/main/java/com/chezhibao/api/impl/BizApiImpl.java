/*
 * FileName: BizServiceImpl.java
 * Author:   Arshle
 * Date:     2018年01月12日
 * Description: 业务整合服务实现
 */
package com.chezhibao.api.impl;

import com.chezhibao.aucs.entity.Auction;
import com.chezhibao.aucs.intf.AuctionService;
import com.chezhibao.boss.entity.Detect;
import com.chezhibao.boss.intf.DetectService;
import com.chezhibao.crm.entity.Customer;
import com.chezhibao.crm.intf.CustomerService;
import com.chezhibao.api.BizApi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * 〈业务整合服务实现〉<br>
 * 〈业务整合服务实现类〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
@Service("bizApi")
public class BizApiImpl implements BizApi {
    /**
     * 客户服务
     */
    @SuppressWarnings("unused")
    @Resource
    private CustomerService customerService;
    /**
     * 检测服务
     */
    @SuppressWarnings("unused")
    @Resource
    private DetectService detectService;
    /**
     * 竞拍服务
     */
    @Resource
    private AuctionService auctionService;
    /**
     * 执行业务逻辑
     * @param customer 客户信息
     * @param detect 检测信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void invoke(Customer customer, Detect detect, Auction auction) {
        //执行分布式服务
        customerService.addCustomer(customer);
        detectService.addDetect(detect);
        auctionService.addAuction(auction);
    }
}
