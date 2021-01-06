package com.hm.hospitalproject.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 检查单
 */
@Entity
@Data
public class checkIterm {
    /**
     * 检查单的自增ID，主键
     */
    @Id
    private Integer ID;
    /**
     * 和检查单关联的checkId
     */
    @Column
    private Integer checkId;

    /**
     * 和检查单关联的医生
     */
    @Column
    private String doctorName;

    /**
     * 检查单开出的时间
     */
    @Column
    private Date gmt_create;
    /**
     * 和使用检查单的患者
     */
    @Column
    private Integer patientId;
    /**
     * 是否检查
     */
    @Column
    private Boolean jiesuan;


}
