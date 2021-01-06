package com.hm.hospitalproject.server;

import com.hm.hospitalproject.entity.DoctorInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/06/23:54
 * @Description:
 */
@Service
public interface DoctorServer {
    DoctorInfo getDoctorInfoByshenfenzheng(String shenfenzheng);
    List<DoctorInfo> getAllDoctorInfo();
    List<DoctorInfo> getpageDoctorInfo(int start,int size);

    List<DoctorInfo> getdoctorByroomname(String roomname);
    DoctorInfo getDoctorInfoByid(int  id);

}
