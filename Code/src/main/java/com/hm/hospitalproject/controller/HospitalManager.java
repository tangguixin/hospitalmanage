package com.hm.hospitalproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/13:18
 * @Description:
 */

@Controller
public class HospitalManager {
    private static Logger log = LoggerFactory.getLogger(PatientController.class);
    @RequestMapping(value = "/manager")
    public String manager(){
        log.info("医院管理员界面  排班时间 药物进货 收银台等（选做）");
        return "/manager";
    }
}
