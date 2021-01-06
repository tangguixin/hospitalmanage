package com.hm.hospitalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:08
 * @Description:
 */


@RestController
@RequestMapping(value ="doctorAction")
@Api(value = "对医生的所有操作",description = "获取医生信息，添加病历单，开检验单...等接口")
public class DocController {
    private static Logger log = LoggerFactory.getLogger(PatientController.class);




    @RequestMapping(value = "/getAlldoctors",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有的医生的列表",httpMethod = "GET")
    public String getAlldoctors(){

        return "这里应该返回所有医生的list";
    }


    @RequestMapping(value = "/getdoctorsByroom",method = RequestMethod.GET)
    @ApiOperation(value = "根据部门信息获取医生列表",httpMethod = "GET")
    public String getdoctorsByroom(HttpServletRequest response,
                        @RequestParam(value ="room",required = true) String room){
        return "这里应该根据部门名返回医生List";
    }

    //给病人添加检验单接口
    @RequestMapping(value = "/addchecklist",method = RequestMethod.POST)
    @ApiOperation(value = "给病人添加检验单接口",httpMethod = "POST")
    public String addchecklist(HttpServletRequest response,
                                   @RequestParam(value ="patientId",required = true) String patientId,
                                  @RequestParam(value ="doctorId",required = true) String doctorId,
                                       @RequestParam(value ="checkId",required = true) String checkId
            ){
        return "这里应该返回所有医生的list";
    }




    //给病人添加处方接口
    //给病人添加检验单接口
    @RequestMapping(value = "/addprescription",method = RequestMethod.POST)
    @ApiOperation(value = "给病人添加检验单接口",httpMethod = "POST")
    public String addprescription(HttpServletRequest response,
                               @RequestParam(value ="patientId",required = true) String patientId,
                               @RequestParam(value ="doctorId",required = true) String doctorId,
                               @RequestParam(value ="drugid",required = true) String drugid
                               ){
        return "存药单成功";
    }
    //给病人添加病例接口人

    @RequestMapping(value = "/addcaserecoder",method = RequestMethod.POST)
    @ApiOperation(value = "给病人添加检验单接口",httpMethod = "POST")
    public String addcaserecoder(HttpServletRequest response,
                                  @RequestParam(value ="patientId",required = true) String patientId,
                                  @RequestParam(value ="doctorId",required = true) String doctorId,
                                  @RequestParam(value ="还有各种药单需要的参数......",required = true) String string
    ){
        return "存病历成功";
    }

    //查询所有历史病例接口

    @RequestMapping(value = "/getAllrecoderBypatientid",method = RequestMethod.POST)
    @ApiOperation(value = "查病人历史病历",httpMethod = "POST")
    public String getAllrecoderByid(HttpServletRequest response,
                                 @RequestParam(value ="patientId",required = true) String patientId,
                                 @RequestParam(value ="doctorId",required = true) String doctorId,
                                 @RequestParam(value ="还有各种药单需要的参数......",required = true) String string
    ){
        return "返回病人历史病历list";
    }


    //根据历史病例id查询详细历史病例接口


    @RequestMapping(value = "/getDetailrecoderBypatientid",method = RequestMethod.POST)
    @ApiOperation(value = "查病人历史病历",httpMethod = "POST")
    public String getDetailrecoderBypatientid(HttpServletRequest response,
                                    @RequestParam(value ="patientId",required = true) String patientId,
                                    @RequestParam(value ="doctorId",required = true) String doctorId,
                                    @RequestParam(value ="caseId",required = true) String caseId
    ){
        return "返回病人某个历史病历详情";
    }

    //  通过用户id将用户从队列中拿出来的接口

    @RequestMapping(value = "/pullqueue",method = RequestMethod.POST)
    @ApiOperation(value = "查病人历史病历",httpMethod = "POST")
    public String pullqueue(HttpServletRequest response,
                                    @RequestParam(value ="patientId",required = true) String patientId
    ){
        return "就诊，从队列中拿出";
    }



}
