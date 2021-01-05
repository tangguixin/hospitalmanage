package com.hm.hospitalproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:11
 * @Description:
 */
@Controller
public class PharmacyController {
    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @RequestMapping(value = "/pharmacy")
    public String pharmacy(){
        log.info("药房界面");
        return "/pharmacy";
    }
}
