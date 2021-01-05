package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Entity
public class prescription {
    /**
     * 药单本身的自增ID，主键
     */
    @Id
    private Integer id;

    /**
     * 药单对应的患者名
     */
    @Column
    private Integer patientId;

    /**
     * 开具药单的医生
     */
    @Column
    private Integer doctorId;

    /**
     * 开具药单的时间
     */
    @Column
    private Date gmt_create;

    /**
     * 药单对应的药品
     */
    @Column
    private String  medicalName;

    @Column
    private Timestamp creatTime;
    /**
     * 药单是否使用(取出药)
     */
    @Column
    private boolean  jiesuan;

}
