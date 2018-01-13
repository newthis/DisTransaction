/*
 * FileName: AuctionDao.java
 * Author:   Arshle
 * Date:     2018年01月13日
 * Description: 竞拍Dao层
 */
package com.chezhibao.aucs.dao;

import com.chezhibao.aucs.entity.Auction;

import java.util.List;

/**
 * 〈竞拍Dao层〉<br>
 * 〈竞拍数据库操作接口〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public interface AuctionDao {
    /**
     * 新增竞拍数据
     * @param auction 竞拍数据
     */
    void insert(Auction auction);
    /**
     * 删除竞拍数据
     * @param auction 竞拍数据
     */
    void delete(Auction auction);
    /**
     * 修改竞拍数据
     * @param auction 竞拍数据
     * @return 影响行数
     */
    int update(Auction auction);
    /**
     * 根据ID查询竞拍数据
     * @param id ID
     * @return 竞拍数据
     */
    Auction getById(long id);
    /**
     * 查询所有竞拍列表
     * @return 竞拍列表
     */
    List<Auction> queryAll();
}
