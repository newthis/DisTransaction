/*
 * FileName: LogBackInitializer.java
 * Author:   Arshle
 * Date:     2018年01月11日
 * Description: logback初始化配置类
 */
package com.chezhibao.initializer;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import java.io.File;

/**
 * 〈logback初始化配置类〉<br>
 * 〈初始化加载logback配置〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
public class LogBackInitializer {

    private static Logger logger;
    /**
     * linux logback配置文件路径
     */
    private String linuxConfPath = "/opt/logback/";
    /**
     * logback配置文件名
     */
    private String logbackName = "logback.xml";
    /**
     * logback配置文件初始化
     */
    public void init(){
        /*logback初始化*/
        LoggerContext loggerContext = null;
        //初始化logback上下文环境
        if(LoggerContext.class.isInstance(LoggerFactory.getILoggerFactory())){
            loggerContext = LoggerContext.class.cast(LoggerFactory.getILoggerFactory());
        }
        if(loggerContext == null){
            loggerContext = (LoggerContext) StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        try {
            //加载logback配置
            JoranConfigurator configurator = new JoranConfigurator();
            //清除原logback状态
            loggerContext.getStatusManager().clear();
            loggerContext.reset();
            //设置上下文
            configurator.setContext(loggerContext);
            //优先加载/opt/logback下,其次本地编译目录下
            File logbackFile = new File(linuxConfPath + logbackName);
            if(!logbackFile.exists()){
                logbackFile = new File(this.getClass().getClassLoader().getResource("/").getPath() + "logback.xml");
            }
            configurator.doConfigure(logbackFile);
            logger = LoggerFactory.getLogger("initializer");
            logger.info("logback init success");
        } catch (Exception e) {
            if(logger == null){
                logger = LoggerFactory.getLogger(LogBackInitializer.class);
            }
            logger.error("logback init failed");
        }
    }
    public String getLinuxConfPath() {
        return linuxConfPath;
    }

    public void setLinuxConfPath(String linuxConfPath) {
        this.linuxConfPath = linuxConfPath;
    }

    public String getLogbackName() {
        return logbackName;
    }

    public void setLogbackName(String logbackName) {
        this.logbackName = logbackName;
    }
}
