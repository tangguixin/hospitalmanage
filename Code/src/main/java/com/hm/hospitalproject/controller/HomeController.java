package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.domain.users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class HomeController {
    private static Logger log = LoggerFactory.getLogger(PatientController.class);
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String indexOf(HttpServletRequest request, HttpSession session){

        String shenfenzheng=request.getParameter("shenfenzheng");
        String password=request.getParameter("password");
        String type=request.getParameter("type");

        //repository通过参数返回user对象;
        users user=new users();

        if (user!=null){
            if (user.getType().equals("病人")){
                session.setAttribute("patient",user);
            }else if (user.getType().equals("")){

            }
        }else {

            String errMsg = "{\"errMsg\":\"用户名或者密码错误\"}";
            return errMsg;
        }





        log.info("身份证"+shenfenzheng+"   "+"密码"+password);
        return "/ligin";

    }


}
