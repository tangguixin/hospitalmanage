package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.entity.PatientInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/06/8:56
 * @Description:
 */
@Controller
@Api(value = "页面路径映射",description = "定位基础页面路径")
@RequestMapping(value = "/")
public class HomeController {

    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @ApiOperation(value = "定位到登录页面",httpMethod = "GET")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String login1() {
        return "user/login";
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
            return "userCenter/userCenter";
        }
        return "index/index";
    }

    @ApiOperation(value = "定位到分诊台界面",httpMethod = "POST")
    @RequestMapping(value = "/doctorlogin", method = RequestMethod.POST)
    public String doctorlogin(Model model, String userPassword,HttpSession session,
                              HttpServletRequest request) {
        String error = "";
        if (userPassword.equals("123456")) {
           // 返回所有预约表信息
            return "分诊界面";
        }
        else {
            error = "密码错误";
            log.info(error);
            model.addAttribute("error", error);
            return "user/doctorlogin";
        }

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
