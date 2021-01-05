package com.hm.hospitalproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:08
 * @Description:
 */


@Controller
public class DocController {
    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @RequestMapping(value = "/doctor")
    public String doctor(){
        log.info("医生界面");
        return "/doctor";
    }
}
