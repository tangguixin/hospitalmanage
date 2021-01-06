package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.entity.*;
import com.hm.hospitalproject.server.*;
import com.hm.hospitalproject.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:08
 * @Description:
 */


@Controller
@RequestMapping(value ="doctorAction")
@Api(value = "对医生的所有操作",description = "获取医生信息，添加病历单，开检验单...等接口")
public class DocController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private DoctorServer doctorServer;

    @Autowired
    private PageUtils pageUtils;

    @Autowired
    private RoomServer roomServer;

    @Autowired
    private CheckServer checkServer;

    @Autowired
    private PrescriptionServer prescriptionServer;

    @Autowired
    private CaserecoderServer caserecoderServer;



    @ApiOperation(value = "获取所有专家的列表",httpMethod = "GET")
    @RequestMapping(value = "/doctorIndex/{page}")
    public String doctorIndex(Model model, @PathVariable("page") int page) {
       // 获得所有专家的AppointmentScheduleDO的函数

        List<DoctorInfo> doctorInfoList= doctorServer.getAllDoctorInfo();
        pageUtils.setCurrentPage(page);

        pageUtils.setTotalRecord(doctorInfoList.size());
        int start;
        if (pageUtils.getCurrentPage()==0){
            start=0;
        }else {
            start=pageUtils.getPageRecord()*(pageUtils.getCurrentPage()-1);
        }
      List<DoctorInfo> list=doctorServer.getpageDoctorInfo(start,pageUtils.getPageRecord());
        model.addAttribute("pages", pageUtils);
        model.addAttribute("doctorlist", list);
        return "doctor/doctorIndex";
    }


    @ApiOperation(value = "获取所有部门的列表",httpMethod = "GET")
    @RequestMapping(value = "/officeIndex/{page}")
    public String officeIdex(Model model, @PathVariable("page") int page) {
        List<RoomInfo> list=roomServer.getAllroos();
        // 设置页面
        pageUtils.setCurrentPage(page);
        pageUtils.setTotalRecord(list.size());

        model.addAttribute("pages", pageUtils);
        model.addAttribute("officeRe", list);
        return "office/officeIndex";
    }




    @ApiOperation(value = "根据部门信息获取医生列表",httpMethod = "GET")
    @RequestMapping(value = "/officeInfoShow/{id}", method = RequestMethod.GET)
    public String hosInfoShow(Model model, @PathVariable(value = "id") int id) {
        RoomInfo office = roomServer.findroomByid(id);//根据id返回科室

        List<DoctorInfo> doctorlist = doctorServer.getdoctorByroomname(office.getRoomname());//返回该科室所有医生
        model.addAttribute("office", office);
        model.addAttribute("doctor", doctorlist);
        return "office/officeInfoShow";
    }


    @ApiOperation(value = "根据id获取专家",httpMethod = "GET")
    @RequestMapping(value = "/doctorInfoShow/{id}", method = RequestMethod.GET)
    public String doctorInfoShow(Model model, @PathVariable(value = "id") int id) {
        DoctorInfo doctor=doctorServer.getDoctorInfoByid(id);
        model.addAttribute("doctor", doctor);
        return "doctor/doctorInfoShow";
    }



    //给病人添加检验单接口
    @RequestMapping(value = "/addchecklist",method = RequestMethod.POST)
    @ApiOperation(value = "给病人添加检验单接口",httpMethod = "POST")
    public String addchecklist(HttpServletRequest response,
                                   @RequestParam(value ="patientId",required = true) int  patientId,
                                  @RequestParam(value ="doctorId",required = true) String  doctorname,
                                       @RequestParam(value ="checkId",required = true) int checkId
            ){
        CheckIterm checkIterm=new CheckIterm();
        checkIterm.setCheckId(checkId);
        checkIterm.setPatientId(patientId);
        checkIterm.setDoctorName(doctorname);
        if (checkServer.addCheck(checkIterm)){
            return "ok";
        }else {
            return "fail";
        }
    }


    //给病人添加处方接口
    //给病人添加检验单接口
    @RequestMapping(value = "/addprescription",method = RequestMethod.POST)
    @ApiOperation(value = "给病人添加检验单接口",httpMethod = "POST")
    public String addprescription(HttpServletRequest response,
                               @RequestParam(value ="patientId",required = true) int  patientId,
                               @RequestParam(value ="doctorId",required = true) int  doctorId,
                               @RequestParam(value ="drugid",required = true) int  drugid
                               ){

        Prescription prescription=new Prescription();
        prescription.setPatientId(patientId);
        prescription.setDoctorId(doctorId);
        prescription.setDrugid(drugid);

        if (prescriptionServer.addPrescription(prescription)){
            return "sucess";
        }else {
            return "fail";
        }

    }
    //给病人添加病例接口人

    @RequestMapping(value = "/addcaserecoder",method = RequestMethod.POST)
    @ApiOperation(value = "给病人添加病例",httpMethod = "POST")
    public String addcaserecoder(HttpServletRequest response,
                                  @RequestParam(value ="patientId",required = true) int patientId,
                                  @RequestParam(value ="doctorId",required = true) int  doctorId,
                                  @RequestParam(value ="还有各种药单需要的参数......",required = true) String string
    ){
        CaseRecoder caseRecoder=new CaseRecoder();
        caseRecoder.setDoctorId(doctorId);
        caseRecoder.setPatientsId(patientId);
        caseRecoder.setZhusu(string);
        if (caserecoderServer.addcaserecoder(caseRecoder)){
            return "sucess";
        }else {
            return "fail";
        }
    }



    //查询所有历史病例接口
    @RequestMapping(value = "/getAllrecoderBypatientid/{page}",method = RequestMethod.GET)
    @ApiOperation(value = "查病人历史病历",httpMethod = "GET")
    public String getAllrecoderByid(Model model, @PathVariable("page") int page,
                                 @RequestParam(value ="patientId",required = true) int patientId,
                                 @RequestParam(value ="doctorId",required = true) int doctorId
    ){
        if (doctorServer.getDoctorInfoByid(doctorId).getDoctorName().equals("医生")){
            List<CaseRecoder> lists=caserecoderServer.getAllcas();
            pageUtils.setCurrentPage(page);
            pageUtils.setTotalRecord(lists.size());
            int start;
            if (pageUtils.getCurrentPage()==0){
                start=0;
            }else {
                start=pageUtils.getPageRecord()*(pageUtils.getCurrentPage()-1);
            }
            List<CaseRecoder> list=caserecoderServer.getpagecas(start,pageUtils.getPageRecord());

            model.addAttribute("pages", pageUtils);
            model.addAttribute("caselist", list);

        }else {   return "权限不够";}
        return "权限不够";


    }



    //根据历史病例id查询详细历史病例接口


    @RequestMapping(value = "/getDetailrecoderBypatientid",method = RequestMethod.POST)
    @ApiOperation(value = "查病人历史病历",httpMethod = "POST")
    public String getDetailrecoderBypatientid(Model model,
                                    @RequestParam(value ="caseId",required = true) int  caseId
    ){
        CaseRecoder caseRecoder=caserecoderServer.getcaseBycaseId(caseId);
        model.addAttribute("详情",caseRecoder);
        return "success";
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
