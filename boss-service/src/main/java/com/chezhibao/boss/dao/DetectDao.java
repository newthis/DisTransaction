/*
 * FileName: DetectDao.java
 * Author:   Arshle
 * Date:     2018年01月12日
 * Description: 检测Dao层
 */
package com.chezhibao.boss.dao;

import com.chezhibao.boss.entity.Detect;
import java.util.List;

/**
 * 〈检测Dao层〉<br>
 * 〈检测数据库操作层接口〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public interface DetectDao {
    /**
     * 新增检测单
     * @param detect 检测单信息
     */
    void insert(Detect detect);
    /**
     * 删除检测单
     * @param detect 检测单信息
     */
    void delete(Detect detect);
    /**
     * 修改检测单
     * @param detect 检测单信息
     * @return 影响行数
     */
    int update(Detect detect);
    /**
     * 根据ID查询检测单
     * @param id 检测单ID
     * @return 检测单
     */
    Detect getById(long id);
    /**
     * 查询所有检测单
     * @return 检测单列表
     */
    List<Detect> queryAll();
}
