package com.hm.hospitalproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data

public class DoctorInfo {
    @TableId
    private Integer doctorId;

    private String doctorAbout;

    private String doctorForte;

    private String doctorImg;

    private String doctorName;

    private Integer doctorPhone;

    private String doctorSex;

    private String doctorTitle;

    private String officesName;
    private String userName;

    private String shenfenzheng;

}