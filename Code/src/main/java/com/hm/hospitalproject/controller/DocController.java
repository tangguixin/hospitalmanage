package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.domain.doctorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:08
 * @Description:
 */


@Controller
@RequestMapping(value ="doctorAction")
public class DocController {
    private static Logger log = LoggerFactory.getLogger(PatientController.class);




    @RequestMapping(value = "/doctor")
    public String doctor(){
        log.info("医生界面");
        return "/doctor";
    }



    @RequestMapping(value = "getAllDctor")
    @ResponseBody
    public List<doctor> getAllDctor(){
    }


    @RequestMapping(value = "getDctorByroom")
    @ResponseBody
    public List<doctor> getAllDctor(){
    }


}
