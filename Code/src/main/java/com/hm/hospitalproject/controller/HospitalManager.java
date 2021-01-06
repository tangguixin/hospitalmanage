package com.hm.hospitalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/13:18
 * @Description:
 */

@RequestMapping("hospitalAction")
@Api(value = "医院相关api",description = "eg:")
public class HospitalManager {
    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @RequestMapping(value = "/getAlldrugs",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有药物列表",httpMethod = "GET")
    public String getAlldrugs(){

        return "这里应该返回所有药物的list";
    }


    @RequestMapping(value = "/getAllchecks",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有检查项列表",httpMethod = "GET")
    public String getAllchecks(){

        return "这里应该返回所有检查的list";
    }




}
