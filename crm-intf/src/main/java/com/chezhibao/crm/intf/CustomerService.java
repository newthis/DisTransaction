/*
 * FileName: CustomerService.java
 * Author:   Arshle
 * Date:     2018年01月11日
 * Description: 客户操作服务接口
 */
package com.chezhibao.crm.intf;

import com.chezhibao.crm.entity.Customer;
import java.util.List;

/**
 * 〈客户操作服务接口〉<br>
 * 〈客户操作服务接口〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public interface CustomerService {
    /**
     * 根据ID查询客户
     * @param id 客户ID
     * @return 客户信息
     */
    Customer queryCustomerById(long id);
    /**
     * 新增客户
     * @param customer 客户信息
     */
    void addCustomer(Customer customer);
    /**
     * 删除客户
     * @param customer 客户信息
     */
    void removeCustomer(Customer customer);
    /**
     * 修改客户信息
     * @param customer 客户信息
     * @return 影响行数
     */
    int updateCustomer(Customer customer);
    /**
     * 查询所有客户
     * @return 客户列表
     */
    List<Customer> queryAllCustomers();
}
