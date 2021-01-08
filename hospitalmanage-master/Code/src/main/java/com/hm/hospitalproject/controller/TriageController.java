package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.entity.OnlineGuahao;
import com.hm.hospitalproject.server.YuyueServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:10
 * @Description:
 */
@Controller
public class TriageController {
    private static Logger log = LoggerFactory.getLogger(TriageController.class);

    @Autowired
    YuyueServer yuyueServer;

    @RequestMapping(value = "/fenzhenlogin1")
    public String fenzhenlogin1(
            Model model,
            @RequestParam(value ="userPassword",required = true) String userPassword ){
        String error;
        if (userPassword.equals("123456")){

            List<OnlineGuahao> list=yuyueServer.getyuyueAll();
            model.addAttribute("list",list);
            return "/user/fenzhen";
        }
        error="密码错误";
        model.addAttribute("error",error);
        return "user/fenzhenlogin";

    }


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
