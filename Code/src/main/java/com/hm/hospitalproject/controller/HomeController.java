package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.domain.users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:08
 * @Description:
 */
@Controller
@Api(value = "登录系统",description = "登录页面请求Api")
public class HomeController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @ApiOperation(value = "登录页面",httpMethod = "GET")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login1() {
        return "/login";
    }



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "登录接口，成功后获取cookies",httpMethod = "POST")
    public String login(HttpServletRequest response,
                          @RequestParam(value ="shenfenzheng",required = true) String shenfenzheng,
                          @RequestParam(value = "password", required = true) String password,
                             @RequestParam(value = "type", required = true) String type,HttpSession session){
        session.setAttribute("name","12212");

        return "登录成功";
    }



}


