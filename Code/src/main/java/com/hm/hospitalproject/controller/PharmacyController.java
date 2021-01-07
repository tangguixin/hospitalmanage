package com.hm.hospitalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:11
 * @Description:
 */
@Controller
@Api(value = "药房系统",description = "药房系统")
@RequestMapping("pharmacyAction")
public class PharmacyController {
    private static Logger log = LoggerFactory.getLogger(PharmacyController.class);


    //根据用户id查询处方接口
    @RequestMapping(value = "/getAllprescriptionById",method = RequestMethod.GET)
    @ApiOperation(value = "查询处方",httpMethod = "GET")
    public String pullqueue(HttpServletRequest response,
                            @RequestParam(value ="patientId",required = true) String patientId
    ){
        return "就诊，从队列中拿出";
    }



    //将处方加入队列接口
    @RequestMapping(value = "/addchufangqueue",method = RequestMethod.POST)
    @ApiOperation(value = "将处方加入队列接口",httpMethod = "POST")
    public String addchufangqueue(HttpServletRequest response,
                            @RequestParam(value ="id",required = true) String id
    ){
        return "就诊，从队列中拿出";
    }

    //配药接口
    @RequestMapping(value = "/addpeiyaoqueue",method = RequestMethod.POST)
    @ApiOperation(value = "将处方加入配药队列接口",httpMethod = "POST")
    public String addpeiyaoqueue(HttpServletRequest response,
                                  @RequestParam(value ="id",required = true) String id
    ){
        return "配药中";
    }

    //发药接口
    @RequestMapping(value = "/fayao",method = RequestMethod.POST)
    @ApiOperation(value = "发药",httpMethod = "POST")
    public String fayao(HttpServletRequest response,
                                 @RequestParam(value ="id",required = true) String id
                        ){

        //修改处方中某字段
        return "配药中";
    }

    //退药接口

    @RequestMapping(value = "/tuiyao",method = RequestMethod.POST)
    @ApiOperation(value = "退药",httpMethod = "POST")
    public String tuiyao(HttpServletRequest response,
                        @RequestParam(value ="patient",required = true) String patient,
                         @RequestParam(value ="caseId",required = true) String caseId

    ){
        //修改处方中某字段
        return "配药中";
    }
}
