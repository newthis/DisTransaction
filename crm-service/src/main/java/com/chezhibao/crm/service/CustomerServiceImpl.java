/*
 * FileName: CustomerServiceImpl.java
 * Author:   Arshle
 * Date:     2018年01月11日
 * Description: 客户操作服务实现
 */
package com.chezhibao.crm.service;

import com.chezhibao.crm.dao.CustomerDao;
import com.chezhibao.crm.entity.Customer;
import com.chezhibao.crm.intf.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * 〈客户操作服务实现〉<br>
 * 〈客户操作服务具体实现〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public class CustomerServiceImpl implements CustomerService {

    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    /**
     * 客户Dao
     */
    @Resource
    private CustomerDao customerDao;
    /**
     * 根据ID查询客户
     * @param id 客户ID
     * @return 客户信息
     */
    @Override
    public Customer queryCustomerById(long id) {
        try {
            return customerDao.getById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return new Customer();
    }
    /**
     * 新增客户
     * @param customer 客户信息
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public void addCustomer(Customer customer) {
        customerDao.insert(customer);
    }
    /**
     * 删除客户
     * @param customer 客户信息
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public void removeCustomer(Customer customer) {
        customerDao.delete(customer);
    }
    /**
     * 修改客户信息
     * @param customer 客户信息
     * @return 影响行数
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public int updateCustomer(Customer customer) {
        return customerDao.update(customer);
    }
    /**
     * 查询所有客户
     * @return 客户列表
     */
    @Override
    public List<Customer> queryAllCustomers() {
        return customerDao.queryAll();
    }
}
