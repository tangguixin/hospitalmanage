package com.hm.hospitalproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;


@Data
public class CaseRecoder {

    private Integer caseId;

    private Date creatTime;

    private Integer doctorId;

    private String jiazhushi;

    private Integer patientsId;

    private String xianbingshi;

    private String zhusu;

}