/*
 * FileName: AuctionService.java
 * Author:   Arshle
 * Date:     2018年01月13日
 * Description: 竞拍服务接口
 */
package com.chezhibao.aucs.intf;

import com.chezhibao.aucs.entity.Auction;
import java.util.List;

/**
 * 〈竞拍服务接口〉<br>
 * 〈竞拍服务相关接口〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public interface AuctionService {
    /**
     * 新增竞拍数据
     * @param auction 竞拍数据
     */
    void addAuction(Auction auction);
    /**
     * 删除竞拍数据
     * @param auction 竞拍数据
     */
    void removeAuction(Auction auction);
    /**
     * 修改竞拍数据
     * @param auction 竞拍数据
     * @return 影响行数
     */
    int updateAuction(Auction auction);
    /**
     * 根据ID查询竞拍数据
     * @param id ID
     * @return 竞拍数据
     */
    Auction queryAuctionById(long id);
    /**
     * 查询所有竞拍数据
     * @return 竞拍列表
     */
    List<Auction> queryAllAuctions();
}
