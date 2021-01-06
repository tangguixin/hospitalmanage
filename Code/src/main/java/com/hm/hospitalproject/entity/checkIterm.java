package com.hm.hospitalproject.entity;


import lombok.Data;


import java.util.Date;

/**
 * 检查单
 */

@Data
public class checkIterm {
    /**
     * 检查单的自增ID，主键
     */

    private Integer ID;
    /**
     * 和检查单关联的checkId
     */

    private Integer checkId;

    /**
     * 和检查单关联的医生
     */

    private String doctorName;

    /**
     * 检查单开出的时间
     */

    private Date gmt_create;
    /**
     * 和使用检查单的患者
     */

    private Integer patientId;
    /**
     * 是否检查
     */

    private Boolean jiesuan;


}
