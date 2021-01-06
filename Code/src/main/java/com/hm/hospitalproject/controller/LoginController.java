package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.entity.DoctorInfo;
import com.hm.hospitalproject.entity.PatientInfo;
import com.hm.hospitalproject.server.DoctorServer;
import com.hm.hospitalproject.server.PatientServer;
import com.hm.hospitalproject.server.UserServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping(value = "/loginAction")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);


    private DoctorInfo  doctorInfo;

    @Autowired
    private UserServer userServer;

    @Autowired
    private PatientServer patientServer;

    @Autowired
    private DoctorServer doctorServer;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "登录接口，成功后获取cookies",httpMethod = "POST")
    public String login(HttpServletRequest response, Model model,
                        @RequestParam(value ="shenfenzheng",required = true) String shenfenzheng,
                        @RequestParam(value = "password", required = true) String password,
                        @RequestParam(value = "type", required = true) String type, HttpSession session){

        Boolean islogin= userServer.login(shenfenzheng,password,type);

        if(type.equals("病人")&&islogin) {
            PatientInfo patient=patientServer.getPatientInfoByshenfenzheng(shenfenzheng);
            model.addAttribute("user", patient);
            session.setAttribute("userInfo", patient);
            return "index/index";
        }
        else if(type.equals("医生")&&islogin) {
            DoctorInfo doctor=doctorServer.getDoctorInfoByshenfenzheng(shenfenzheng);
            model.addAttribute("user", doctor);
            session.setAttribute("userInfo", doctor);
           return "医生界面";
        }
        else if(type.equals("药房")&&islogin)
        {
            DoctorInfo doctor=doctorServer.getDoctorInfoByshenfenzheng(shenfenzheng);
            model.addAttribute("user", doctor);
            session.setAttribute("userInfo", doctor);
            return "药房界面";
        }else {
        return "登录主页";
        }
    }

    @ApiOperation(value = "用户退出",httpMethod = "GET")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "登录界面";
    }



}


