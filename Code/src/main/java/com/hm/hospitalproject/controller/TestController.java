package com.hm.hospitalproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/02/15:33
 * @Description:
 */
@RestController
public class TestController {
    @RequestMapping
    public String test(){
        return "Hello SpringBoot";
    }
}
