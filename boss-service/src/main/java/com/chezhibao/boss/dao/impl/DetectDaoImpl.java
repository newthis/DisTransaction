/*
 * FileName: DetectDaoImpl.java
 * Author:   Arshle
 * Date:     2018年01月12日
 * Description: 检测单Dao实现类
 */
package com.chezhibao.boss.dao.impl;

import com.alibaba.fastjson.JSON;
import com.chezhibao.boss.dao.DetectDao;
import com.chezhibao.boss.entity.Detect;
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
 * 〈检测单Dao实现类〉<br>
 * 〈检测单数据库操作层实现类〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
@Repository("detectDao")
public class DetectDaoImpl implements DetectDao {

    private Logger logger = LoggerFactory.getLogger(DetectDaoImpl.class);
    /**
     * jdbcTemplate
     */
    @Resource
    private JdbcTemplate jdbcTemplate;
    /**
     * 新增检测单
     * @param detect 检测单信息
     */
    @Override
    public void insert(Detect detect) {
        logger.info("Begin Invoke:DetectDaoImpl.insert,params:" + JSON.toJSONString(detect));
        String sql = "insert into detect_info values (null,?,?,?,?,?,?)";
        logger.info("execute sql:" + sql);
        jdbcTemplate.update(sql,detect.getRegion(),detect.getEngineerId(),detect.getEngineerName(),detect.getAddress(),detect.getStatus(),detect.getCustomerId());
    }
    /**
     * 删除检测单
     * @param detect 检测单信息
     */
    @Override
    public void delete(Detect detect) {
        logger.info("Begin Invoke:DetectDaoImpl.delete,params:" + JSON.toJSONString(detect));
        String sql = "delete from detect_info where id = ?";
        logger.info("execute sql:" + sql);
        jdbcTemplate.update(sql, detect.getId());
    }
    /**
     * 修改检测单
     * @param detect 检测单信息
     * @return 影响行数
     */
    @Override
    public int update(Detect detect) {
        logger.info("Begin Invoke:DetectDaoImpl.update,params:" + JSON.toJSONString(detect));
        String sql = "update detect_info set ";
        if(detect.getRegion() > 0){
            sql += "region = " + detect.getRegion() + ",";
        }
        if(detect.getEngineerId() > 0){
            sql += "engineerId = " + detect.getEngineerId() + ",";
        }
        if(!StringUtils.isEmpty(detect.getEngineerName())){
            sql += "engineerName = '" + detect.getEngineerName() + "',";
        }
        if (!StringUtils.isEmpty(detect.getAddress())) {
            sql += "address = '" + detect.getAddress() + "',";
        }
        if(detect.getStatus() > 0){
            sql += "status = " + detect.getStatus() + ",";
        }
        if(detect.getCustomerId() > 0){
            sql += "customerId = " + detect.getCustomerId() + ",";
        }
        sql = sql.substring(0,sql.length() - 1);
        sql += " where id = " + detect.getId();
        logger.info("execute sql:" + sql);
        return jdbcTemplate.update(sql);
    }
    /**
     * 根据ID查询检测单
     * @param id 检测单ID
     * @return 检测单
     */
    @Override
    public Detect getById(long id) {
        logger.info("Begin Invoke:DetectDaoImpl.getById,params:{id:" + id + "}");
        String sql = "select * from detect_info where id = ?";
        logger.info("execute sql:" + sql);
        return jdbcTemplate.queryForObject(sql,new DetectRowMapper(),id);
    }
    /**
     * 查询所有检测单
     * @return 检测单列表
     */
    @Override
    public List<Detect> queryAll() {
        logger.info("Begin Invoke:DetectDaoImpl.queryAll");
        String sql = "select * from detect_info";
        logger.info("execute sql:" + sql);
        return jdbcTemplate.query(sql, new DetectRowMapper());
    }
    /**
     * 检测RowMapper
     */
    class DetectRowMapper implements RowMapper<Detect>{
        /**
         * 映射关系
         * @param resultSet ResultSet
         * @param i 行数
         * @return 检测单
         * @throws SQLException sql异常
         */
        @Override
        public Detect mapRow(ResultSet resultSet, int i) throws SQLException {
            Detect detect = new Detect();
            detect.setId(resultSet.getLong("id"));
            detect.setRegion(resultSet.getInt("region"));
            detect.setEngineerId(resultSet.getLong("engineerId"));
            detect.setEngineerName(resultSet.getString("engineerName"));
            detect.setAddress(resultSet.getString("address"));
            detect.setStatus(resultSet.getInt("status"));
            detect.setCustomerId(resultSet.getLong("customerId"));
            return detect;
        }
    }
}
