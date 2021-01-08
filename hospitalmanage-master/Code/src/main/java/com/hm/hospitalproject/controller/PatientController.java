package com.hm.hospitalproject.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.entity.*;
import com.hm.hospitalproject.mapper.CheckItermMapper;
import com.hm.hospitalproject.mapper.DrugsMapper;
import com.hm.hospitalproject.mapper.InspectionItemsMapper;
import com.hm.hospitalproject.mapper.PrescriptionMapper;
import com.hm.hospitalproject.server.YuyueServer;
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
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/9:09
 * @Description:患者操作界面
 */

@Api(value = "患者界面",description = "患者页面请求Api")

@Controller
public class PatientController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @Autowired
    private YuyueServer yuyueServer;

    @Autowired
    CheckItermMapper checkItermMapper;

    @Autowired
    InspectionItemsMapper inspectionItemsMapper;

    @Autowired
    PrescriptionMapper prescriptionMapper;

    @Autowired
    DrugsMapper drugsMapper;


//异常
    @ApiOperation(value = "上传患者预约信息",httpMethod = "POST")
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public String order (String orderInfoValue,Model model,
                               int userId,
                               int doctorId,
                               int roomId,
                               String ordertime,
                               String type){

        String error;
        //onlineGuahao.setRoomId(roomId);

        if ( yuyueServer.addone(userId,doctorId,roomId,type,orderInfoValue)){
            error="预约成功";
            return "index/index";
        }
        error="预约失败";
        model.addAttribute("error",error);
        return "index/index";
    }




    @ApiOperation(value = "分诊台挂号",httpMethod = "POST")
    @RequestMapping(value = "/fenzhenorder",method = RequestMethod.POST)
    public String fenzhenorder (Model model,HttpServletRequest response, @RequestParam(value = "userid",required = false) String userid)
    {
        String error="生成排队号成功";
        model.addAttribute("error",error);


        return "user/fenzhen";

    }

    @ApiOperation(value = "病人取消预约接口",httpMethod = "POST")
    @RequestMapping(value = "/onlinecancel",method = RequestMethod.GET)
    public String onlinecancel (HttpServletRequest response,
                                @RequestParam(value = "orderId",required = true) int orderId
    ){
        yuyueServer.cancelyuyue(orderId);
        return "ok";
    }



    //结算接口

    @ApiOperation(value = "用户结算接口",httpMethod = "POST")
    @RequestMapping(value = "/onlinePay",method = RequestMethod.GET)
    public String onlinepay (HttpServletRequest response, HttpSession session,
                             Model model
    ){
        //查询所有生效检查单的条件Wrapper
        PatientInfo commonUser = (PatientInfo) session.getAttribute("userInfo");
        int userId=commonUser.getUserId();

        QueryWrapper<CheckIterm> checkQueryWrapper = new QueryWrapper<CheckIterm>();
        checkQueryWrapper.like("patient_id",userId).like("jiesuan",true);

        //查询具体检查价格的Wrapper
        QueryWrapper<InspectionItems> inspectionItemsQueryWrapper = new QueryWrapper<InspectionItems>();

        //查询所有生效药单的Wrapper
        QueryWrapper<Prescription> prescriptionQueryWrapper = new QueryWrapper<Prescription>();
        prescriptionQueryWrapper.like("patient_id",userId).like("jiesuan",true);

        //查询具体药品价格的Wrapper
        QueryWrapper<Drugs> drugsQueryWrapper = new QueryWrapper<Drugs>();


        //找到该患者的所有的已经生效的药单
        List<CheckIterm> checkIterms =checkItermMapper.selectList(checkQueryWrapper);
        //根据检查单对应的checkid寻找其对应的价格并相加
        double checkOfSum = 0;
        for(CheckIterm checkIterm:checkIterms){
            int checkId=checkIterm.getCheckId();
            inspectionItemsQueryWrapper.like("check_id",checkId);
            InspectionItems inspectionItems = (InspectionItems) inspectionItemsMapper.selectOne(inspectionItemsQueryWrapper);
            checkOfSum += (inspectionItems.getCost());
        }

        //查询患者的所有已经生效的药单
        List<Prescription> prescriptions=prescriptionMapper.selectList(prescriptionQueryWrapper);
         int inspectOfSum = 0;

        for(Prescription prescription:prescriptions){
            int drugid = prescription.getDrugid();
            drugsQueryWrapper.like("drug_id",drugid);
            Drugs drugs = (Drugs) drugsMapper.selectOne(drugsQueryWrapper);
            inspectOfSum += Integer.parseInt(drugs.getPrice());
        }

        //通过传入参数userId去数据库操作 也可以后端直接通过session
        model.addAttribute("commonUser",commonUser);
        model.addAttribute("pay",100);
        return "/pay/payout";
    }

}
