/*
 * FileName: CustomerDaoImpl.java
 * Author:   Arshle
 * Date:     2018年01月11日
 * Description: 客户信息Dao实现
 */
package com.chezhibao.crm.dao.impl;

import com.alibaba.fastjson.JSON;
import com.chezhibao.crm.dao.CustomerDao;
import com.chezhibao.crm.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 〈客户信息Dao实现〉<br>
 * 〈客户信息数据库操作层实现类〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    private Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);
    /**
     * jdbcTemplate
     */
    @Resource
    private JdbcTemplate jdbcTemplate;
    /**
     * 根据ID获取客户信息
     * @param id 客户ID
     * @return 客户信息
     */
    @Override
    public Customer getById(long id) {
        logger.info("Begin Invoke:CustomerDaoImpl.getById,params:{id:" + id + "}");
        String sql = "select * from customer_info where id = ?";
        logger.info("execute sql:" + sql);
        return jdbcTemplate.queryForObject(sql,new CustomerRowMapper(),id);
    }
    /**
     * 新增客户数据
     * @param customer 客户信息
     */
    @Override
    public void insert(Customer customer) {
        logger.info("Begin Invoke:CustomerDaoImpl.insert,params:" + JSON.toJSONString(customer));
        String sql = "insert into customer_info values (null,'" + customer.getName() + "'," + customer.getSex() + "," + customer.getRegion() + ",'" + customer.getMobile() + "','" + customer.getEmail() + "'," + customer.getServiceId() + ",'" + customer.getServiceName() + "')";
        logger.info("execute sql:" + sql);
        jdbcTemplate.execute(sql);
    }
    /**
     * 删除客户数据
     * @param customer 客户信息
     */
    @Override
    public void delete(Customer customer) {
        logger.info("Begin Invoke:CustomerDaoImpl.delete,params:" + JSON.toJSONString(customer));
        String sql = "delete from customer_info where id = " + customer.getId();
        logger.info("execute sql:" + sql);
        jdbcTemplate.execute(sql);
    }
    /**
     * 修改客户数据
     * @param customer 客户信息
     * @return 影响行数
     */
    @Override
    public int update(Customer customer) {
        logger.info("Begin Invoke:CustomerDaoImpl.update,params:" + JSON.toJSONString(customer));
        String sql = "update customer_info set ";
        if(!StringUtils.isEmpty(customer.getName())){
            sql += "name = '" + customer.getName() + "',";
        }
        if(customer.getSex() > 0){
            sql += "sex = " + customer.getSex() + ",";
        }
        if(customer.getRegion() > 0){
            sql += "region = " + customer.getRegion() + ",";
        }
        if(!StringUtils.isEmpty(customer.getMobile())){
            sql += "mobile = '" + customer.getMobile() + "',";
        }
        if(!StringUtils.isEmpty(customer.getEmail())){
            sql += "email = '" + customer.getEmail() + "',";
        }
        if(customer.getServiceId() > 0){
            sql += "serviceId = " + customer.getServiceId() + ",";
        }
        if(!StringUtils.isEmpty(customer.getServiceName())){
            sql += "serviceName = '" + customer.getServiceName() + "',";
        }
        sql = sql.substring(0,sql.length() - 1);
        sql += " where id = " + customer.getId();
        logger.info("execute sql:" + sql);
        return jdbcTemplate.update(sql);
    }
    /**
     * 查询所有客户列表
     * @return 客户列表
     */
    @Override
    public List<Customer> queryAll() {
        logger.info("Begin Invoke:CustomerDaoImpl.queryAll");
        String sql = "select * from customer_info";
        logger.info("execute sql:" + sql);
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }
    /**
     * 客户转化
     */
    class CustomerRowMapper implements RowMapper<Customer>{
        /**
         * 映射关系
         * @param rs ResultSet
         * @param rowNum 行数
         * @return 客户对象
         * @throws SQLException sql异常
         */
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getLong("id"));
            customer.setName(rs.getString("name"));
            customer.setSex(rs.getInt("sex"));
            customer.setRegion(rs.getInt("region"));
            customer.setMobile(rs.getString("mobile"));
            customer.setEmail(rs.getString("email"));
            customer.setServiceId(rs.getLong("serviceId"));
            customer.setServiceName(rs.getString("serviceName"));
            return customer;
        }
    }
}
