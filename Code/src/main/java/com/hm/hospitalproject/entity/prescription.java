package com.hm.hospitalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    private Integer id;

    private Date creatTime;

    private Integer doctorId;

    private Integer drugid;

    private Date gmtCreate;

    private Integer jiesuan;

    private Integer patientId;


}