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
@RestController
@Api(value = "/home",description = "这是hong页面所有请求")
public class HomeController {
    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    /**
     * @param request 传入的参数（身份证号，密码，用户类型）
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request, HttpSession session) {

        String shenfenzheng = request.getParameter("shenfenzheng");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        log.info("身份证" + shenfenzheng + "   " + "密码" + password);
        //repository通过参数返回user对象;
        users user = new users();

        if (user != null) {
            if (user.getType().equals("病人")) {
                session.setAttribute("patient", user);
            } else if (user.getType().equals("")) {
            }
            //.......
            String userJson = null;
            return userJson;
        } else {
            String errMsg = "{\"errMsg\":\"用户名或者密码错误\"}";
            return errMsg;
        }
    }
    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies",httpMethod = "POST")
    public String login11(HttpServletRequest response,
                          @RequestParam(value ="shenfenzheng",required = true) String shenfenzheng,
                          @RequestParam(value = "password", required = true) String password,
                             @RequestParam(value = "type", required = true) String type){
        if (true){
            return "success";
        }
        else {
            return "dd121";
        }

    }



}


