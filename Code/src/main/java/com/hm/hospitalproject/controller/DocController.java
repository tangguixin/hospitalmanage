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


//获取医生列表
    @RequestMapping(value = "getAllDctor")
    @ResponseBody
    public List<doctor> getAllDctor(){
    }


    /**
     * @return 根据部门名称获取医生列表
     */
    @RequestMapping(value = "getDctorByroom")
    @ResponseBody
    public List<doctor> getAllDctor(){
    }

    //给病人添加检验单接口

    //通过用户id将用户从队列中拿出来的接口

    //给病人添加处方接口

    //给病人添加病例接口

    //查询所有历史病例接口

    //根据历史病例id查询详细历史病例接口

    //


}
