/*
 * FileName: BizServiceImpl.java
 * Author:   Arshle
 * Date:     2018年01月12日
 * Description: 业务整合服务实现
 */
package com.chezhibao.api.impl;

import com.chezhibao.boss.entity.Detect;
import com.chezhibao.boss.intf.DetectService;
import com.chezhibao.crm.entity.Customer;
import com.chezhibao.crm.intf.CustomerService;
import com.chezhibao.api.BizApi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
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
     * 执行业务逻辑
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public void invoke() {
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
        detect.setEngineerName("南京aaaaaaaaaaaaaaaaaaaaaaa");
        detect.setEngineerId(3);
        detect.setRegion(2072);
        detectService.addDetect(detect);
    }
}
