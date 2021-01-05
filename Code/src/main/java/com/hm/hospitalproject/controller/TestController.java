package com.hm.hospitalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/02/15:33
 * @Description:
 */
@Controller
public class TestController {
    @RequestMapping("/hello")
    @ResponseBody
    public String test(){
        return "Hello SpringBoot 12dsdsds3";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String indexOf(){
        return "test";
    }
}
