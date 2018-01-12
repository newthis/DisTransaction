/*
 * FileName: DetectServiceImpl.java
 * Author:   Arshle
 * Date:     2018年01月12日
 * Description: 检测服务实现类
 */
package com.chezhibao.boss.service;

import com.chezhibao.boss.dao.DetectDao;
import com.chezhibao.boss.entity.Detect;
import com.chezhibao.boss.intf.DetectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * 〈检测服务实现类〉<br>
 * 〈检测服务相关实现类〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public class DetectServiceImpl implements DetectService {

    private Logger logger = LoggerFactory.getLogger(DetectServiceImpl.class);
    /**
     * 检测dao
     */
    @Resource
    private DetectDao detectDao;
    /**
     * 新增检测单
     * @param detect 检测单
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public void addDetect(Detect detect) {
        detectDao.insert(detect);
    }
    /**
     * 删除检测单
     * @param detect 检测单
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public void removeDetect(Detect detect) {
        detectDao.delete(detect);
    }
    /**
     * 修改检测单
     * @param detect 检测单
     * @return 影响行数
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    @Override
    public int updateDetect(Detect detect) {
        return detectDao.update(detect);
    }
    /**
     * 根据ID查询检测单
     * @param id 检测单id
     * @return 检测单信息
     */
    @Override
    public Detect queryDetectById(long id) {
        try {
            return detectDao.getById(id);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return new Detect();
    }
    /**
     * 查询所有检测单
     * @return 检测单列表
     */
    @Override
    public List<Detect> queryAllDetects() {
        return detectDao.queryAll();
    }
}
