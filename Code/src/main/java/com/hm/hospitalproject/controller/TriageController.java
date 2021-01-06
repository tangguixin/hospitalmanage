package com.hm.hospitalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:10
 * @Description:
 */
@RestController
@Api(value = "分诊台系统",description = "分诊台系统")
@RequestMapping("trageAction")
public class TriageController {
    private static Logger log = LoggerFactory.getLogger(TriageController.class);



    //根据用户id查询预约表接口

    @RequestMapping(value = "/findonlineGuahaobyId",method = RequestMethod.GET)
    @ApiOperation(value = "分诊台根据用户信息查找预约",httpMethod = "GET")
    public String pullqueue(HttpServletRequest response,
                            @RequestParam(value ="patientId",required = true) String patientId
    ){
        return "分诊台确认信息";
    }


    //根据用户id加入排队队列接口
    @RequestMapping(value = "/addqueue",method = RequestMethod.POST)
    @ApiOperation(value = "根据patient加入队列",httpMethod = "POST")
    public String addqueue(HttpServletRequest response,
                            @RequestParam(value ="patientId",required = true) String patientId
    ){
        return "分诊台排队";
    }

}
