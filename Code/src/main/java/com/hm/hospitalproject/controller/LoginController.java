package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.entity.DoctorInfo;
import com.hm.hospitalproject.entity.PatientInfo;
import com.hm.hospitalproject.entity.Prescription;
import com.hm.hospitalproject.entity.Users;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:08
 * @Description:
 */

@Api(value = "登录系统",description = "登录页面请求Api")
@Controller
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);


    private DoctorInfo  doctorInfo;

    @Autowired
    private UserServer userServer;

    @Autowired
    private PatientServer patientServer;

    @Autowired
    private DoctorServer doctorServer;


  //异常
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后获取cookies",httpMethod = "POST")
    public String login(HttpServletRequest response, Model model,
                        @RequestParam(value ="userIdenf",required = true) String userIdenf,
                        @RequestParam(value = "userPassword", required = true) String userPassword,
                        @RequestParam(value = "userType", required = true) String userType, HttpSession session){

        Boolean islogin= userServer.login(userIdenf,userPassword,userType);

        if(userType.equals("病人")&&islogin) {
            PatientInfo patient=patientServer.getPatientInfoByshenfenzheng(userIdenf);

            PatientInfo patient1=new PatientInfo();
            patient1.setShenfenzheng("111");
            patient1.setUserAddress("asfasfd");
            patient1.setUserId(2);
            patient1.setUserName("aaa");
            patient1.setUserPhone("4621654");
            patient1.setUserPassword("111");
            patient1.setUserSex("男");

            model.addAttribute("user", patient1);
            session.setAttribute("userInfo", patient1);
            return "index/index";
        }
        else if(userType.equals("医生")&&islogin) {
            DoctorInfo doctor=doctorServer.getDoctorInfoByshenfenzheng(userIdenf);
           return "doctor/doctorcaozuo";
        }
        else if(userType.equals("药房")&&islogin)
        {
            //DoctorInfo doctor=doctorServer.getDoctorInfoByshenfenzheng(userIdenf);
            List<Prescription> py=new ArrayList<>();
            Prescription prescription=new Prescription();
            prescription.setId(1);
            prescription.setDrugid(1);
            prescription.setPatientId(1);
            prescription.setJiesuan(1);
            for(int i=1;i<4;i++)
            {
                py.add(prescription);
            }
            model.addAttribute("orderRecords",py);
            session.setAttribute("orderRecords",py);
            return "yaofang/pharmacy";
        }else {

        return "user/login";
        }
    }

    @ApiOperation(value = "用户退出",httpMethod = "GET")
    @RequestMapping(value = "/logOff", method = RequestMethod.GET)
    public String logOff(HttpSession session){
        session.invalidate();
        return "index/index";
    }

    @ApiOperation(value = "test",httpMethod = "GET")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public Users test(HttpSession session){
     Users ser=userServer.test();
        return ser;
    }



}


