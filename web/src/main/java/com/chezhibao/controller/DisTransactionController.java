/*
 * FileName: DisTransactionController.java
 * Author:   Arshle
 * Date:     2018年01月11日
 * Description: 分布式事务Controller
 */
package com.chezhibao.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chezhibao.crm.entity.Customer;
import com.chezhibao.crm.intf.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈分布式事务Controller〉<br>
 * 〈分布式事务的控制层〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
@Controller("disTransactionController")
@RequestMapping("/index")
public class DisTransactionController {

    private Logger logger = LoggerFactory.getLogger(DisTransactionController.class);
    /**
     * 客户服务
     */
    @SuppressWarnings("unused")
    @Reference
    private CustomerService customerService;
    /**
     * 获取信息
     * @return 信息
     */
    @RequestMapping("/getInfo")
    @ResponseBody
    public Map<String,Object> getInfo(){
        Map<String, Object> result = new HashMap<>(1);
        List<Customer> customers = null;
        try {
            customers = customerService.queryAllCustomers();
            for(Customer customer : customers){
                logger.info(customer.getName());
                logger.info(customer.getMobile());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.put("list", customers);
        return result;
    }
}
