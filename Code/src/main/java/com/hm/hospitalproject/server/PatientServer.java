package com.hm.hospitalproject.server;

import com.hm.hospitalproject.entity.PatientInfo;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/06/23:49
 * @Description:
 */
@Service
public interface PatientServer {
    PatientInfo getPatientInfoByshenfenzheng(String shenfenzheng);


}
