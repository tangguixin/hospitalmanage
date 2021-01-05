package com.hm.hospitalproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:09
 * @Description:患者操作界面
 */
@Controller
public class PatientController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);


    /**
     * @return 跳转到病人操作主页面
     */
    @RequestMapping(value = "/patient",method = RequestMethod.GET)
    public String patien(){
        log.info("病人操作主页");
        return "/patient";
    }


    @RequestMapping(value = "/onlineOrder",method = RequestMethod.POST)
    public String onlineOrder(){
        //解析 post传过来的参数
        //通过构建预约对象
        //操作repository传入数据库，并做业务逻辑
        //返回提前端（操作结果）
        return "onlineOrder/orderInfo";
    }

}
