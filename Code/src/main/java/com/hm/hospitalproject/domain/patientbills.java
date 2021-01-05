package com.hm.hospitalproject.domain;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:26
 * @Description:
 */

//病人收费单表（账单）
public class patientbills {
    private Integer billId;
    private Integer patientId;
    private String billList;
    private Timestamp creatTime;
    private boolean jisuan;
}
