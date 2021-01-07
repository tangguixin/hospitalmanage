package com.hm.hospitalproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CheckIterm {

    private Integer id;

    private Integer checkId;

    private String doctorId;

    private Date gmtCreate;

    private Boolean jiesuan;

    private Integer patientId;


}