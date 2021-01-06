package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/0:13
 * @Description: 医生基础啊信息表
 */
@Data
@Entity
public class doctorInfor {
    /*
    可直接在这里添加
     */
    // id
    @Id
    private Integer doctorId;
    // 医生姓名
    @Column
    private String doctorName;
    // 医生性别
    @Column
    private String doctorSex;
    //医生电话
    @Column
    private Integer doctorPhone;
    // 科室名称
    @Column
    private String officesName;
    // 医生照片
    @Column
    private String doctorImg;
    // 医生职称
    @Column
    private String doctorTitle;
    // 医生特长
    @Column
    private String doctorForte;
    // 医生关于
    @Column
    private String doctorAbout;
    //最大预约人数
    @Column
    private Integer max;
}
