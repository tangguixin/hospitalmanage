package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.entity.*;
import com.hm.hospitalproject.mapper.CaseRecoderMapper;
import com.hm.hospitalproject.server.*;
import com.hm.hospitalproject.utils.PageUtils;
import com.hm.hospitalproject.utils.Queuing;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;





@Api(value = "对医生的所有操作",description = "获取医生信息，添加病历单，开检验单...等接口")
@Controller
public class DocController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);


    @Autowired
    private DoctorServer doctorServer;
    @Autowired
    private office room ;
    @Autowired
    private CheckServer checkServer;
    @Autowired
    private PrescriptionServer prescriptionServer;
    @Autowired
    private CaserecoderServer caserecoderServer;

    @Autowired
    private CaseRecoderMapper caseRecoderMapper;
    @Autowired
    Queuing queuing;



    //返回所有医生/专家列表(异常)

    @ApiOperation(value = "获取所有专家的列表",httpMethod = "GET")
    @RequestMapping(value = "/doctorIndex")
    public String doctorIndex(Model model,HttpSession session) {
        //List<DoctorInfo> doctorInfoList= doctorServer.getAllDoctorInfo();
        List<DoctorInfo> doctorInfoList=new ArrayList<>();
        DoctorInfo a1=new  DoctorInfo();
        a1.setDoctorId(1);
        a1.setDoctorImg("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=125118597,2644951849&fm=26&gp=0.jpg");
        a1.setDoctorName("aaa");
        a1.setDoctorPhone(562464);
        a1.setOfficesName("内科");
        a1.setDoctorSex("男");
        doctorInfoList.add(a1);
        DoctorInfo a2=new  DoctorInfo();
        a2.setDoctorId(2);
        a2.setDoctorImg("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=125118597,2644951849&fm=26&gp=0.jpg");
        a2.setDoctorName("aaa");
        a2.setDoctorPhone(562464);
        a2.setOfficesName("内科");
        a2.setDoctorSex("男");
        doctorInfoList.add(a2);
        DoctorInfo a3=new  DoctorInfo();
        a3.setDoctorId(3);
        a3.setDoctorImg("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=125118597,2644951849&fm=26&gp=0.jpg");
        a3.setDoctorName("aaa");
        a3.setDoctorPhone(562464);
        a3.setOfficesName("内科");
        a3.setDoctorSex("男");
        doctorInfoList.add(a3);
        model.addAttribute("doctor", doctorInfoList);
        return "doctor/doctorIndex";
    }



    //返回所有部门列表(可用)

    @ApiOperation(value = "获取所有部门的列表",httpMethod = "GET")
    @RequestMapping(value = "/officeIndex")
    public String officeIndex(Model model) {
        model.addAttribute("allrooms",room.getAllroos());
        return "office/officeIndex";
    }


   //根据部门信息获取医生列表(异常)
    @ApiOperation(value = "根据部门信息获取医生列表",httpMethod = "GET")
    @RequestMapping(value = "/officeInfoShow/{officeId}", method = RequestMethod.GET)
    public String hosInfoShow(Model model, @PathVariable(value = "officeId") int officeId, HttpSession session) {

        //RoomInfo office = room.findroomByid(officeId);

        //List<DoctorInfo> doctorlist = doctorServer.getdoctorByroomname(office.getRoomname());
        RoomInfo office =new RoomInfo(1,"asdhasjhdash","内科");
        List<DoctorInfo> doctorInfoList=new ArrayList<>();
        DoctorInfo a1=new  DoctorInfo();
        a1.setDoctorId(1);
        a1.setDoctorImg("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=125118597,2644951849&fm=26&gp=0.jpg");
        a1.setDoctorName("aaa");
        a1.setDoctorPhone(562464);
        a1.setOfficesName("内科");
        a1.setDoctorSex("男");
        doctorInfoList.add(a1);
        DoctorInfo a2=new  DoctorInfo();
        a2.setDoctorId(2);
        a2.setDoctorImg("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=125118597,2644951849&fm=26&gp=0.jpg");
        a2.setDoctorName("aaa");
        a2.setDoctorPhone(562464);
        a2.setOfficesName("内科");
        a2.setDoctorSex("男");
        doctorInfoList.add(a2);
        DoctorInfo a3=new  DoctorInfo();
        a3.setDoctorId(3);
        a3.setDoctorImg("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=125118597,2644951849&fm=26&gp=0.jpg");
        a3.setDoctorName("aaa");
        a3.setDoctorPhone(562464);
        a3.setOfficesName("内科");
        a3.setDoctorSex("男");
        doctorInfoList.add(a3);
        model.addAttribute("office", office);
        model.addAttribute("doctor", doctorInfoList);
        session.setAttribute("office", office);
        return "office/officeInfoShow";
    }


    //根据id获取专家（异常）

    @ApiOperation(value = "根据id获取专家",httpMethod = "GET")
    @RequestMapping(value = "/doctorInfoShow/{id}", method = RequestMethod.GET)

    public String doctorInfoShow(Model model,
                                 @PathVariable(value = "id") int id,HttpSession session){

        //DoctorInfo doctor=doctorServer.getDoctorInfoByid(id);
        DoctorInfo a1=new  DoctorInfo();
        a1.setDoctorId(1);
        a1.setDoctorImg("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=125118597,2644951849&fm=26&gp=0.jpg");
        a1.setDoctorName("aaa");
        a1.setDoctorPhone(562464);
        a1.setOfficesName("内科");
        a1.setDoctorSex("男");
        RoomInfo office =(RoomInfo) session.getAttribute("office");
        model.addAttribute("doctor", a1);
        return "doctor/doctorInfoShow";
    }



    //给病人添加检验单接口(异常)

    @RequestMapping(value = "/addchecklist",method = RequestMethod.POST)
    @ApiOperation(value = "给病人添加检验单接口",httpMethod = "POST")
    public String addchecklist(HttpServletRequest response,Model model,
                                   @RequestParam(value ="patientId",required = true) int  patientId,
                                  @RequestParam(value ="doctorId",required = true) String  doctorId,
                                       @RequestParam(value ="checkId",required = true) int checkId
            ){
        String error;
        //CheckIterm checkIterm=new CheckIterm();

        //checkIterm.setCheckId(checkId);
        //checkIterm.setPatientId(patientId);
        //checkIterm.setDoctorId(doctorId);

        if (true){
            error="生成成功";
            model.addAttribute("error",error);
            return "doctor/doctorcaozuo";
        }else {
            error="生成失败";
            model.addAttribute("error",error);
            return "doctor/doctorcaozuo";
        }
    }


    //给病人添加处方接口（异常）

    @RequestMapping(value = "/addprescription111",method = RequestMethod.POST)
    @ApiOperation(value = "给病人添加处方单接口",httpMethod = "POST")
    public String addprescription(Model model,
                               @RequestParam(value ="patientId",required = true) int  patientId,
                               @RequestParam(value ="doctorId",required = true) int  doctorId,
                               @RequestParam(value ="drugid",required = true) int  drugId
                               ){
        String error;
        //Prescription prescription=new Prescription();
        //prescription.setPatientId(patientId);
        //prescription.setDoctorId(doctorId);
        //prescription.setDrugid(drugId);

        if (true){
            error="生成成功";
            model.addAttribute("error",error);
            return "doctor/doctorcaozuo";
        }else {
            error="生成失败";
            model.addAttribute("error",error);
            return "doctor/doctorcaozuo";
        }


    }


    //添加病例(可用)

    @RequestMapping(value = "/addcaserecoder",method = RequestMethod.POST)
    @ApiOperation(value = "给病人添加病例",httpMethod = "POST")
    public String addcaserecoder(HttpServletRequest response,Model model,
                                  @RequestParam(value ="patientId",required = true) int patientId,
                                  @RequestParam(value ="doctorId",required = true) int  doctorId,
                                  @RequestParam(value ="string",required = true) String string
    ){
        String error;
        CaseRecoder caseRecoder=new CaseRecoder();
        caseRecoder.setDoctorId(doctorId);
        caseRecoder.setPatientsId(patientId);
        caseRecoder.setZhusu(string);
        if (caserecoderServer.addcaserecoder(caseRecoder)==1){
            error="生成成功";
            model.addAttribute("error",error);
            return "doctor/doctorcaozuo";
        }else {
            error="生成失败";
            model.addAttribute("error",error);
            return "doctor/doctorcaozuo";
        }
    }



    //查询所有历史病例接口（可用）

    @RequestMapping(value = "/getAllrecoderBypatientid",method = RequestMethod.POST)
    @ApiOperation(value = "查病人全部历史病历",httpMethod = "POST")
    public String getAllrecoderByid(Model model,
                                 @RequestParam(value ="patientId",required = true) int patientId
    ){
        List<CaseRecoder> lists=caserecoderServer.getAllcas(patientId);
        model.addAttribute("caselist", lists);
        return "doctor/showallcaseRecoder";
    }



    //根据历史病例id查询详细历史病例接口（异常）

    @RequestMapping(value = "/getDetailrecoderBypatientid",method = RequestMethod.POST)
    @ApiOperation(value = "根据历史病例id查询详细历史病例接口",httpMethod = "POST")
    @ResponseBody
    public String getDetailrecoderBypatientid(Model model,
                                    @RequestParam(value ="caseId",required = true) int  caseId
    ){
        CaseRecoder caseRecoder=caserecoderServer.getcaseBycaseId(caseId);
        model.addAttribute("detailcase",caseRecoder);
        return caseRecoder.toString();
    }

    //医生点击就诊排队结束（）

    @RequestMapping(value = "/pullqueue",method = RequestMethod.POST)
    @ApiOperation(value = "查病人历史病历",httpMethod = "POST")
    public String pullqueue(HttpServletRequest response,
                            @RequestParam(value ="patientId",required = true) String patientId
    ){
        String docName = "tets";
        String times = "2020-1-1";
        Queuing.getQueue(docName+times);
        Queuing.popMan(docName+times,Integer.parseInt(patientId));
        return "就诊，从队列中拿出";
    }


}
