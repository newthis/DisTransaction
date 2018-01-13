/*
 * FileName: BizServiceImpl.java
 * Author:   Arshle
 * Date:     2018年01月12日
 * Description: 业务整合服务实现
 */
package com.chezhibao.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chezhibao.boss.entity.Detect;
import com.chezhibao.boss.intf.DetectService;
import com.chezhibao.crm.entity.Customer;
import com.chezhibao.crm.intf.CustomerService;
import com.chezhibao.service.BizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.UserTransaction;

/**
 * 〈业务整合服务实现〉<br>
 * 〈业务整合服务实现类〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
@Service("bizService")
public class BizServiceImpl implements BizService{

    private Logger logger = LoggerFactory.getLogger(BizServiceImpl.class);
    /**
     * 客户服务
     */
    @SuppressWarnings("unused")
    @Reference
    private CustomerService customerService;
    /**
     * 检测服务
     */
    @SuppressWarnings("unused")
    @Reference
    private DetectService detectService;
    /**
     * 用户类型事务
     */
    @Autowired
    @Qualifier("atomikosUserTransaction")
    private UserTransaction userTransaction;
    /**
     * 执行业务逻辑
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public void invoke() {
        try {
            userTransaction.begin();
            Customer customer = new Customer();
            customer.setName("华念文");
            customer.setSex(1);
            customer.setRegion(2072);
            customer.setMobile("13813812300");
            customer.setEmail("sadasdasd");
            customer.setServiceId(2);
            customer.setServiceName("吴静");
            customerService.addCustomer(customer);
            Detect detect = new Detect();
            detect.setStatus(302);
            detect.setAddress("南京市软件大道");
            detect.setEngineerName("南京南京南京南京南京南京南京");
            detect.setEngineerId(3);
            detect.setRegion(2072);
            detectService.addDetect(detect);
            userTransaction.commit();
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            try {
                userTransaction.rollback();
            } catch (Exception e1) {
                logger.error(e1.getMessage(),e1);
            }
        }
    }
}
