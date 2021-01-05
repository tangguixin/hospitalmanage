package com.hm.hospitalproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String indexOf(){
        log.info("所有用户登录主页");
        return "index";
        /*
        所有主页和前端交互
         */
    }


}
