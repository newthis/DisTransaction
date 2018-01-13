/*
 * FileName: DisTransactionUtils.java
 * Author:   Arshle
 * Date:     2018年01月13日
 * Description: 分布式事务管理器工具类
 */
package com.chezhibao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.transaction.UserTransaction;

/**
 * 〈分布式事务管理器工具类〉<br>
 * 〈分布式事务的开始、提交和回滚等〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public class DisTransactionUtils{

    private static Logger logger = LoggerFactory.getLogger(DisTransactionUtils.class);
    /**
     * 开启分布式事务
     */
    public static void beginDisTransaction(){
        try {
            getUserTransaction().begin();
        } catch (Exception e) {
            logger.error("begin transaction failed,cause:" + e.getMessage());
        }
    }
    /**
     * 提交分布式事务
     */
    public static void commitDisTransaction(){
        try {
            getUserTransaction().commit();
        } catch (Exception e) {
            logger.error("commit transaction failed,cause:" + e.getMessage());
        }
    }
    /**
     * 回滚分布式事务
     */
    public static void rollbackDisTransaction(){
        try {
            getUserTransaction().rollback();
        } catch (Exception e) {
            logger.error("rollback transaction failed,cause:" + e.getMessage());
        }
    }
    /**
     * 获取用户使用的UserTransaction对象
     * @return UserTransaction
     */
    private static UserTransaction getUserTransaction(){
        UserTransaction userTransaction = (UserTransaction) SpringUtils.getBean("bytejtaUserTransaction");
        if(userTransaction == null){
            logger.error("userTransaction can not be null.");
        }
        return userTransaction;
    }
}
