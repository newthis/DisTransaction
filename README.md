#DisTransaction  
公司内部分布式事务，基于byteJTA + spring + dubbo + zookeeper  
bytejta开源地址:https://github.com/liuyangming/ByteJTA  
集成公司环境的大致架构部署图如下:  
![Alt text](/struct.jpg)  
具体实现方式为MysqlXADataSource数据源 + byteJTA jtaTransactionManager统一事务管理器 +  
byteJTA dubbo远程服务调用拦截器 + spring全局管理实现dubbo分布式事务的二阶段提交(JTA/XA协议)  

具体开发步骤:  
    1.使用指定的数据源(具体正式集成之后根据事务架构进行封装,或使用已封装好的XA数据源client)  
    2.参考demo中aucs-service、boss-service、crm-service中的dubbo配置,发布支持分布式事务  
    的dubbo服务需要在distran-service.xml中按照指定格式配置:  
    <dubbo:service id="springId"  
    				   interface="interfaceClass"  
    				   class="ImplClass"  
    				   group="org.bytesoft.bytejta" filter="transaction"  
    				   loadbalance="transaction" cluster="failfast" retries="0" />  
    注:dubbo的分组、过滤器、负载均衡、集群、重试次数不可修改  
    3.分布式事务的统一开启必须的restful API层统一开启，参考demo中web工程下的BizApiImpl.class  
    