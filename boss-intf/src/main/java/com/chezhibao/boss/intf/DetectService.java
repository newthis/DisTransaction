/*
 * FileName: DetectService.java
 * Author:   Arshle
 * Date:     2018年01月12日
 * Description: 检测Service接口
 */
package com.chezhibao.boss.intf;

import com.chezhibao.boss.entity.Detect;
import java.util.List;

/**
 * 〈检测Service接口〉<br>
 * 〈检测服务接口〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public interface DetectService {
    /**
     * 新增检测单
     * @param detect 检测单
     */
    void addDetect(Detect detect);
    /**
     * 删除检测单
     * @param detect 检测单
     */
    void removeDetect(Detect detect);
    /**
     * 修改检测单
     * @param detect 检测单
     * @return 影响行数
     */
    int updateDetect(Detect detect);
    /**
     * 根据ID查询检测单
     * @param id 检测单id
     * @return 检测单信息
     */
    Detect queryDetectById(long id);
    /**
     * 查询所有检测单
     * @return 检测单列表
     */
    List<Detect> queryAllDetects();
}
