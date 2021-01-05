package com.hm.hospitalproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:10
 * @Description:
 */
@Controller
public class TriageController {
    private static Logger log = LoggerFactory.getLogger(PatientController.class);


    @RequestMapping(value = "/triage")
    public String triage(){
        log.info("分诊台界面 +加入排队队列");
        return "/triage";
    }

    //根据用户id查询预约表接口

    //根据用户id加入排队队列接口
}
