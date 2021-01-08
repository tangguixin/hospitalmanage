package com.hm.hospitalproject.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hm.hospitalproject.DrugConstant;
import com.hm.hospitalproject.entity.PatientInfo;
import com.hm.hospitalproject.entity.Prescription;
import com.hm.hospitalproject.mapper.PrescriptionMapper;
import com.hm.hospitalproject.utils.Queuing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/06/9:51
 * @Description:
 */
@Controller
public class SystemController {

    @Autowired
    Queuing queuing;


    @Autowired
    PrescriptionMapper prescriptionMapper;


    @RequestMapping(value = "/user/state")
    /**
     * 用户在队列中的位置查询
     */
    int quryNumofPeople(String key,int patientId){
        Queuing.getQueue(key);
        return Queuing.countMan(key,patientId);
    }

    /**
     * 领药单状态查询
     */
    String checkthestatus(HttpSession session){

        QueryWrapper<Prescription> prescriptionQueryWrapper = new QueryWrapper<Prescription>();
        PatientInfo patientInfo= (PatientInfo) session.getAttribute("userInfo");

        prescriptionQueryWrapper.eq("patientId",patientInfo.getUserId());

        List<Prescription> prescriptions = prescriptionMapper.selectList(prescriptionQueryWrapper);
        boolean flag1=true;
        boolean flag2=true;
        for(Prescription prescription : prescriptions){
            if(prescription.getJiesuan() == DrugConstant.created){
                return "领药单刚刚创建";
            }else if(prescription.getJiesuan() == DrugConstant.dispensing){
                return "正在配药";
            }else if(prescription.getJiesuan() == DrugConstant.waitDistributeDrugs){
                return "正在等待发药";
            }else if(prescription.getJiesuan() == DrugConstant.distributeDrugs){
                flag1 = false;
            }else if(prescription.getJiesuan() == DrugConstant.backDrug){
                flag2 = false;
            }
        }
        if(flag1 && flag2){
            return "部分退药成功";
        }
        if(flag1){
            return "全部退药成功";
        }
        return "全部发药完成";
    }

}
