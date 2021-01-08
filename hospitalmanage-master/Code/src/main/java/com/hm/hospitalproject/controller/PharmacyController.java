package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.entity.Prescription;
import com.hm.hospitalproject.mapper.YaofangServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:11
 * @Description:
 */
@Controller
public class PharmacyController {
    private static Logger log = LoggerFactory.getLogger(PharmacyController.class);

    @Autowired
    YaofangServer yaofangServer;


    //根据用户id查询处方接口
    @RequestMapping(value = "/getAllprescriptionById",method = RequestMethod.GET)
    @ApiOperation(value = "查询处方",httpMethod = "GET")
    public String pullqueue(HttpServletRequest response, Model model,
                            @RequestParam(value ="patientId",required = true) int  patientId
    ){
        List<Prescription> Prescriptionlist=yaofangServer.getAllbypatientId(patientId);
        String s="";
        for (Prescription k:Prescriptionlist){
            s+=k.getDrugid();
        }

        model.addAttribute("patientId", String.valueOf(patientId));
        model.addAttribute("doctorId", String.valueOf(Prescriptionlist.get(0).getDoctorId()));
        model.addAttribute("yaoid", String.valueOf(s));

        return "/login";
    }



    //等待配药
    @RequestMapping(value = "/addchufangqueue/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "取药",httpMethod = "GET")
    public String addchufangqueue(HttpServletRequest response,Model model,
                            @PathVariable(value ="id",required = true) int id
    ){

        yaofangServer.uppeiyao1(id);


        return "yaofang/pharmacy";
    }

    //正在配药
    @RequestMapping(value = "/addpeiyaoqueue/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "将处方加入配药队列接口",httpMethod = "GET")
    public String addpeiyaoqueue(HttpServletRequest response,Model model,
                                  @PathVariable(value ="id",required = true) int  yaodanid2
    ){

        yaofangServer.uppeiyao2(yaodanid2);
        return "yaofang/pharmacy";
    }

    //已经发药
    @RequestMapping(value = "/fayao/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "发药",httpMethod = "GET")
    public String fayao(HttpServletRequest response,Model model,
                                 @PathVariable(value ="id",required = true) int  yaodanid3
                        ){
        yaofangServer.uppeiyao3(yaodanid3);

        //修改处方中某字段
        return "yaofang/pharmacy";
    }

    //退药

    @RequestMapping(value = "/tuiyao/{caseId}//{patient}",method = RequestMethod.GET)
    @ApiOperation(value = "退药",httpMethod = "GET")
    public String tuiyao(HttpServletRequest response,
                        @RequestParam(value ="patient",required = true) int  patient,
                         @RequestParam(value ="caseId",required = true) int  caseId

    ){
        yaofangServer.tuiyao(caseId,patient);
        //修改处方中某字段
        return "yaofang/pharmacy";
    }
}
