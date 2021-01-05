package com.hm.hospitalproject.domain;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:24
 * @Description:
 */

//医生给病人开的处方表
public class prescription {
    private Integer id;

    private Integer patientId;

    private Integer doctorId;

    private String  chufang;

    private String beizhu;

    private Timestamp creatTime;

    private boolean  jiesuan;

}
