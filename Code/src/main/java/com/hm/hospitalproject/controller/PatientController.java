package com.hm.hospitalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:09
 * @Description:患者操作界面
 */
@Controller
@Api(value = "患者界面",description = "患者页面请求Api")
@RequestMapping(value = "patientAction")
public class PatientController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);


    /**
     * @return 跳转到病人操作主页面
     */
    @ApiOperation(value = "定位到患者界面",httpMethod = "GET")
    @RequestMapping(value = "/patient",method = RequestMethod.GET)
    public String patien(){
        log.info("病人操作主页");
        return "/patient";
    }




    @ResponseBody
    @ApiOperation(value = "患者预约信息",httpMethod = "POST")
    @RequestMapping(value = "/patient/onlineorder",method = RequestMethod.POST)
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

}
