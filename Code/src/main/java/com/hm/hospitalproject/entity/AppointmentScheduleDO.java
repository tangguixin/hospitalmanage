package com.hm.hospitalproject.entity;


import lombok.Data;



/**
 * 医生(或者科室)对应的可预约的时间段,以及时间段对应的剩余的可预约的人数
 */

@Data
public class AppointmentScheduleDO {
    /**
     * 医生名字
     */

    private String doctorName;

    /**
     * 科室ID
     */

    private String roomID;

    /**
     * 可预约时间的开始时间
     */

    private String startTime;

    /**
     * 可预约时间的结束时间
     */

    private String endTime;

    /**
     * 可预约的剩余人数
     */

    private int leftPeople;
}
