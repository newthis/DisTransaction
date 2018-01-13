/*
 * FileName: AuctionServiceImpl.java
 * Author:   Arshle
 * Date:     2018年01月13日
 * Description: 竞拍服务实现类
 */
package com.chezhibao.aucs.service;

import com.chezhibao.aucs.dao.AuctionDao;
import com.chezhibao.aucs.entity.Auction;
import com.chezhibao.aucs.intf.AuctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * 〈竞拍服务实现类〉<br>
 * 〈竞拍服务相关实现〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public class AuctionServiceImpl implements AuctionService {

    private Logger logger = LoggerFactory.getLogger(AuctionServiceImpl.class);
    /**
     * 竞拍dao
     */
    @Resource
    private AuctionDao auctionDao;
    /**
     * 新增竞拍数据
     * @param auction 竞拍数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addAuction(Auction auction) {
        auctionDao.insert(auction);
    }
    /**
     * 删除竞拍数据
     * @param auction 竞拍数据
     */
    @Override
    public void removeAuction(Auction auction) {
        auctionDao.delete(auction);
    }
    /**
     * 修改竞拍数据
     * @param auction 竞拍数据
     * @return 影响行数
     */
    @Override
    public int updateAuction(Auction auction) {
        return auctionDao.update(auction);
    }
    /**
     * 根据ID查询竞拍数据
     * @param id ID
     * @return 竞拍数据
     */
    @Override
    public Auction queryAuctionById(long id) {
        try {
            return auctionDao.getById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return new Auction();
    }
    /**
     * 查询所有竞拍数据
     * @return 竞拍列表
     */
    @Override
    public List<Auction> queryAllAuctions() {
        return auctionDao.queryAll();
    }
}
