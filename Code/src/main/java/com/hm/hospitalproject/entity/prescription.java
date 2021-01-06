package com.hm.hospitalproject.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:24
 * @Description:
 */

//医生给病人开的处方表

@Data
public class prescription {
    /**
     * 药单本身的自增ID，主键
     */

    private Integer id;

    /**
     * 药单对应的患者名
     */

    private Integer patientId;

    /**
     * 开具药单的医生
     */

    private Integer doctorId;

    /**
     * 开具药单的时间
     */

    private Date gmt_create;

    /**
     * 药单对应的药品
     */

    private Integer  drugid;


    private Timestamp creatTime;
    /**
     * 药单是否使用(取出药)
     */

    private boolean  jiesuan;

}
