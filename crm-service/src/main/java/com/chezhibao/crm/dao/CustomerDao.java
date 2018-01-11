/*
 * FileName: CustomerDao.java
 * Author:   Arshle
 * Date:     2018年01月11日
 * Description: 客户信息Dao
 */
package com.chezhibao.crm.dao;

import com.chezhibao.crm.entity.Customer;
import java.util.List;

/**
 * 〈客户信息Dao〉<br>
 * 〈客户信息数据库操作层〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public interface CustomerDao {
    /**
     * 根据ID获取客户信息
     * @param id 客户ID
     * @return 客户信息
     */
    Customer getById(long id);
    /**
     * 新增客户数据
     * @param customer 客户信息
     */
    void insert(Customer customer);
    /**
     * 删除客户数据
     * @param customer 客户信息
     */
    void delete(Customer customer);
    /**
     * 修改客户数据
     * @param customer 客户信息
     * @return 影响行数
     */
    int update(Customer customer);
    /**
     * 查询所有客户列表
     * @return 客户列表
     */
    List<Customer> queryAll();
}
