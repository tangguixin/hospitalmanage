package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.entity.doctorInfo;
import com.hm.hospitalproject.entity.users;
import com.hm.hospitalproject.server.UserServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:08
 * @Description:
 */
@Controller
@Api(value = "登录系统",description = "登录页面请求Api")
@RequestMapping(value = "/loginAction")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);


    private doctorInfo  doctorInfo;

    @Autowired
    private UserServer userServer;



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "登录接口，成功后获取cookies",httpMethod = "POST")
    public String login(HttpServletRequest response,
                          @RequestParam(value ="shenfenzheng",required = true) String shenfenzheng,
                          @RequestParam(value = "password", required = true) String password,
                             @RequestParam(value = "type", required = true) String type,HttpSession session){
        session.setAttribute("name","12212");

       List<users> docs=userServer.getAlluser();
       System.out.println(docs);
        return "登录成功";
    }

    @ApiOperation(value = "用户退出",httpMethod = "GET")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        if (session.getAttribute("users")!=null){

        }else if (true){

        }
        return "/login";
    }



}


