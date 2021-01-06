package com.hm.hospitalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:09
 * @Description:患者操作界面
 */
@RestController
@Api(value = "患者界面",description = "患者页面请求Api")
@RequestMapping(value = "patientAction")
public class PatientController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);


    @ApiOperation(value = "上传患者预约信息",httpMethod = "POST")
    @RequestMapping(value = "/onlineorder",method = RequestMethod.POST)
    public String onlineOrder (HttpServletRequest response,
                               @RequestParam(value = "doctorId",required = false) String doctorId,
                               @RequestParam(value = "roomId",required = false) String roomId,
                               @RequestParam(value = "type",required = true) String type){
        //解析 post传过来的参数
        //通过构建预约对象
        //操作repository传入数据库，并做业务逻辑
        //返回提前端（操作结果）
        //通过表字段issuccess判断是否成功
        return "success";
    }




    @ApiOperation(value = "病人取消预约接口",httpMethod = "POST")
    @RequestMapping(value = "/onlinecancel",method = RequestMethod.GET)
    public String onlinecancel (HttpServletRequest response,
                               @RequestParam(value = "orderId",required = true) String orderId
                              ){
        //通过参数orderId去数据库操作
        return "success";
    }

    //结算接口


    @ApiOperation(value = "用户结算接口",httpMethod = "POST")
    @RequestMapping(value = "/onlinePay",method = RequestMethod.GET)
    public String onlinepay (HttpServletRequest response,
                               @RequestParam(value = "userId",required = true) String userId
    ){


        //通过传入参数userId去数据库操作 也可以后端直接通过session
        return "success";
    }

}
