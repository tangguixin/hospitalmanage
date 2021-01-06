package com.hm.hospitalproject.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 医生(或者科室)对应的可预约的时间段,以及时间段对应的剩余的可预约的人数
 */
@Entity
@Data
public class AppointmentScheduleDO {
    /**
     * 医生名字
     */
    @Id
    private String doctorName;

    /**
     * 科室ID
     */
    @Column
    private String roomID;

    /**
     * 可预约时间的开始时间
     */
    @Column
    private String startTime;

    /**
     * 可预约时间的结束时间
     */
    @Column
    private String endTime;

    /**
     * 可预约的剩余人数
     */
    @Column
    private int leftPeople;
}
