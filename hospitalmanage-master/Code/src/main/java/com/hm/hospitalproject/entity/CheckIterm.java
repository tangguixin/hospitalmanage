package com.hm.hospitalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckIterm {

    private int id;

    private Integer checkId;

    private int doctorId;

    private Date gmtCreate;

    private Boolean jiesuan;

    private Integer patientId;


}