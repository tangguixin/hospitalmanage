package com.hm.hospitalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/06/8:56
 * @Description:
 */


@Api(value = "页面路径映射",description = "定位基础页面路径")
public class HomeController {
    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @ApiOperation(value = "定位到登录页面",httpMethod = "GET")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login1() {
        return "/login";
    }

    /**
     * @return 跳转到病人操作主页面
     */
    @ApiOperation(value = "定位到患者界面",httpMethod = "GET")
    @RequestMapping(value = "/patient",method = RequestMethod.GET)
    public String patien(){
        log.info("病人操作主页");
        return "/patient";
    }
}
