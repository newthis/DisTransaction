/*
 * FileName: DisTransactionController.java
 * Author:   Arshle
 * Date:     2018年01月11日
 * Description: 分布式事务Controller
 */
package com.chezhibao.controller;

import com.chezhibao.api.BizApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈分布式事务Controller〉<br>
 * 〈分布式事务的控制层〉
 *
 * @author Arshle
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本]（可选）
 */
@Controller("disTransactionController")
@RequestMapping("/index")
public class DisTransactionController {

    private Logger logger = LoggerFactory.getLogger(DisTransactionController.class);

    @Resource
    private BizApi bizApi;
    /**
     * 获取信息
     * @return 信息
     */
    @RequestMapping("/getInfo")
    @ResponseBody
    public Map<String,Object> getInfo(){
        Map<String, Object> result = new HashMap<>(1);
        try {
            bizApi.invoke();
            result.put("flag",true);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            result.put("flag",false);
        }
        return result;
    }
}
