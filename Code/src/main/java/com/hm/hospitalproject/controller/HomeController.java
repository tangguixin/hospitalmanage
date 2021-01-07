package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.entity.OnlineGuahao;
import com.hm.hospitalproject.entity.PatientInfo;
import com.hm.hospitalproject.server.YuyueServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/06/8:56
 * @Description:
 */
@Controller
@Api(value = "页面路径映射",description = "定位基础页面路径")
public class HomeController {
    private YuyueServer yuyueServer;

    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @ApiOperation(value = "定位首页",httpMethod = "GET")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index/index";
    }

    @ApiOperation(value = "定位首页",httpMethod = "POST")
    @RequestMapping(value = "/index1",method = RequestMethod.POST)
    public String index1() {
        return "index/index";
    }



    @ApiOperation(value = "定位到登录页面",httpMethod = "GET")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpSession session) {
        return "user/login";
    }


    @GetMapping(value = "/fenzhenlojin")
    public String fenzhenlogin(){
        return "user/fenzhenlogin";
    }

    @GetMapping(value = "/officeindex")
    public String officeindex(){
        return "office/officeIndedx";
    }



    @GetMapping(value = "/doctorIndex")
    public String doctorindex(){
        return "doctor/doctorIndex";
    }




    /**
     * @return 跳转到病人操作主页面
     */
    @ApiOperation(value = "定位到患者界面",httpMethod = "GET")
    @RequestMapping(value = "/userCenter", method = RequestMethod.GET)
    public String userCenter(HttpSession session, Model model) {
        PatientInfo patient = (PatientInfo) session.getAttribute("userInfo");
        if (patient != null) {
            // 得到用户的个人订单
            //根据id返回患者所有预约表
            //        根据id返回患者排队号
           // 根据id返回患者所有处方单



    //     List<OnlineGuahao> onlineGuahao= yuyueServer.getyuyue(patient.getUserId());

            List<OnlineGuahao> list = new ArrayList<>();
            list.add(new OnlineGuahao(1,new Date(12,12,12),"12",false,false,"1","专家",1));
            list.add(new OnlineGuahao(2,new Date(12,12,12),"12",false,false,"1","" +
                    "152",1));
            list.add(new OnlineGuahao(1,new Date(4,12,12),"12",false,false,"1","专家",1));

            model.addAttribute("list",list);
            model.addAttribute("commonUser",patient);
            //model添加patient字段为commonUser
            //model添加排队好字段为waitinfo
            //model添加处方表字段为chufang
            return "/userCenter/userCenter";
        }
        return "/index/login";
    }




    @ApiOperation(value = "定位到分诊台界面",httpMethod = "GET")
    @RequestMapping(value = "/fenzhenlogin", method = RequestMethod.GET)
    public String fenzhenlogin1() {
        return "/user/fenzhenlogin";
    }



    @ApiOperation(value = "预约分诊",httpMethod = "POST")
    @RequestMapping(value = "/fenzhen", method = RequestMethod.POST)
    public String doctorfenzhen(Model model, String orderId,HttpSession session,
                              HttpServletRequest request) {
     //   将orderId指向的预约表状态修改，并将其对应病人生成排队号
        return "分诊界面";


    }


    @ApiOperation(value = "定位到药房",httpMethod = "GET")
    @RequestMapping(value = "/pharmacy")
    public String pharmacy(){
        log.info("药房界面");
        return "/pharmacy";
    }
}
