package com.hm.hospitalproject.server;


import com.hm.hospitalproject.entity.OnlineGuahao;
import com.hm.hospitalproject.entity.PatientInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/2:35
 * @Description:
 */




public interface YuyueServer {
    Boolean addyuyue(OnlineGuahao onlineGuahao);

    Boolean cancelyuyue(int userId);

    List<OnlineGuahao> getyuyue(int userId);
    List<OnlineGuahao> getyuyueAll();


}
