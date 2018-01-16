#DisTransaction
公司内部分布式事务，基于byteJTA + spring + dubbo + zookeeper  
bytejta开源地址:https://github.com/liuyangming/ByteJTA  
集成公司环境的大致架构部署图如下:  
![Alt text](/struct.jpg)  
具体实现方式为MysqlXADataSource数据源 + byteJTA jtaTransactionManager统一事务管理器 +  
byteJTA dubbo远程服务调用拦截器 + spring全局管理实现dubbo分布式事务的二阶段提交(JTA/XA协议)  

