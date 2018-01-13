/*
 * FileName: AuctionDaoImpl.java
 * Author:   Arshle
 * Date:     2018年01月13日
 * Description: 竞拍Dao实现类
 */
package com.chezhibao.aucs.dao;

import com.alibaba.fastjson.JSON;
import com.chezhibao.aucs.entity.Auction;
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
 * 〈竞拍Dao实现类〉<br>
 * 〈竞拍数据库操作层实现类〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
@Repository("auctionDao")
public class AuctionDaoImpl implements AuctionDao {

    private Logger logger = LoggerFactory.getLogger(AuctionDaoImpl.class);
    /**
     * jdbcTemplate
     */
    @Resource
    private JdbcTemplate jdbcTemplate;
    /**
     * 新增竞拍数据
     * @param auction 竞拍数据
     */
    @Override
    public void insert(Auction auction) {
        logger.info("Begin Invoke:AuctionDaoImpl.insert,params:" + JSON.toJSONString(auction));
        String sql = "insert into auction_info values (null,?,?,?,?)";
        logger.info("execute sql:" + sql);
        jdbcTemplate.update(sql,auction.getOrderId(),auction.getScreenName(),auction.getRegion(),auction.getStatus());
    }
    /**
     * 删除竞拍数据
     * @param auction 竞拍数据
     */
    @Override
    public void delete(Auction auction) {
        logger.info("Begin Invoke:AuctionDaoImpl.delete,params:" + JSON.toJSONString(auction));
        String sql = "delete from auction_info where id = ?";
        logger.info("execute sql:" + sql);
        jdbcTemplate.update(sql, auction.getId());
    }
    /**
     * 修改竞拍数据
     * @param auction 竞拍数据
     * @return 影响行数
     */
    @Override
    public int update(Auction auction) {
        logger.info("Begin Invoke:AuctionDaoImpl.update,params:" + JSON.toJSONString(auction));
        String sql = "update auction_info set ";
        if(auction.getOrderId() > 0){
            sql += "orderId = " + auction.getOrderId() + ",";
        }
        if(!StringUtils.isEmpty(auction.getScreenName())){
            sql += "screenName = '" + auction.getScreenName() + "',";
        }
        if(auction.getRegion() > 0){
            sql += "region = " + auction.getRegion() + ",";
        }
        if (auction.getStatus() > 0) {
            sql += "status = " + auction.getStatus() + ",";
        }
        sql = sql.substring(0,sql.length() - 1);
        sql += " where id = " + auction.getId();
        logger.info("execute sql:" + sql);
        return jdbcTemplate.update(sql);
    }
    /**
     * 根据ID查询竞拍数据
     * @param id ID
     * @return 竞拍数据
     */
    @Override
    public Auction getById(long id) {
        logger.info("Begin Invoke:AuctionDaoImpl.getById,params:{id:" + id + "}");
        String sql = "select * from auction_info where id = ?";
        logger.info("execute sql:" + sql);
        return jdbcTemplate.queryForObject(sql,new AuctionRowMapper(),id);
    }
    /**
     * 查询所有竞拍列表
     * @return 竞拍列表
     */
    @Override
    public List<Auction> queryAll() {
        logger.info("Begin Invoke:AuctionDaoImpl.queryAll");
        String sql = "select * from auction_info";
        logger.info("execute sql:" + sql);
        return jdbcTemplate.query(sql, new AuctionRowMapper());
    }
    /**
     * 竞拍RowMapper
     */
    class AuctionRowMapper implements RowMapper<Auction>{
        /**
         * 关系映射
         * @param resultSet ResultSet
         * @param i 行数
         * @return 竞拍实体类
         * @throws SQLException 异常
         */
        @Override
        public Auction mapRow(ResultSet resultSet, int i) throws SQLException {
            Auction auction = new Auction();
            auction.setId(resultSet.getLong("id"));
            auction.setOrderId(resultSet.getLong("orderId"));
            auction.setScreenName(resultSet.getString("screenName"));
            auction.setRegion(resultSet.getInt("region"));
            auction.setStatus(resultSet.getInt("status"));
            return auction;
        }
    }
}
