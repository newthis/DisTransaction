/*
 * FileName: SpringUtils.java
 * Author:   Arshle
 * Date:     2018年01月13日
 * Description: Spring工具类
 */
package com.chezhibao.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 〈Spring工具类〉<br>
 * 〈管理bean等〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public class SpringUtils implements ApplicationContextAware {
    /**
     * spring容器
     */
    private static ApplicationContext context;
    /**
     * 初始化spring容器
     * @param applicationContext 容器
     * @throws BeansException 异常
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(context == null){
            context = applicationContext;
        }
    }
    /**
     * 从spring上下文中获取bean
     * @param beanName bean的名称
     * @return bean对象
     * **/
    public static Object getBean(String beanName){
        return context.getBean(beanName);
    }
    /**
     * 获取bean
     * @param beanType 类型
     * @param <T> 类型
     * @return bean对象
     */
    public static <T> T getBean(Class<T> beanType){
        return context.getBean(beanType);
    }
}
