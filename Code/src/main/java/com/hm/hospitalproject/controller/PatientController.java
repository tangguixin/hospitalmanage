package com.hm.hospitalproject.controller;


import com.hm.hospitalproject.entity.OnlineGuahao;
import com.hm.hospitalproject.server.YuyueServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private YuyueServer yuyueServer;


    @ApiOperation(value = "上传患者预约信息",httpMethod = "POST")
    @RequestMapping(value = "/onlineorder",method = RequestMethod.POST)
    public String onlineOrder (HttpServletRequest response,
                               int userId,
                                       @RequestParam(value = "creattime",required = false) String creattime,
                               @RequestParam(value = "doctorId",required = false) String doctorId,
                               @RequestParam(value = "roomId",required = false) String roomId,
                               @RequestParam(value = "type",required = true) String type){
        OnlineGuahao onlineGuahao=new OnlineGuahao();
        onlineGuahao.setDoctorId(doctorId);
        onlineGuahao.setUserid(userId);
        onlineGuahao.setType(type);
        onlineGuahao.setRoomId(roomId);
        if (yuyueServer.addyuyue(onlineGuahao)){
            return "success";
        }

        return "index/index";
    }




//    @ApiOperation(value = "分诊台挂号",httpMethod = "POST")
//    @RequestMapping(value = "/fenzhenorder",method = RequestMethod.POST)
//    public String onlineOrder (HttpServletRequest response, @RequestParam(value = "userid",required = false) String userid)
//    {
//
//        生成排队号
//
//        return 分诊界面;
//    }

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
