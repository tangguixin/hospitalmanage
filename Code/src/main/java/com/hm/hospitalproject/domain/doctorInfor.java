package com.hm.hospitalproject.domain;/**
 * Created with IntelliJ IDEA.
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/0:13
 * @Description:
 */
//医生基础啊信息表
public class doctorInfor {
    /*
    可直接在这里添加
     */
    // id
    private Integer doctorId;
    // 医生姓名
    private String doctorName;
    // 医生性别
    private String doctorSex;
    //医生电话
    private Integer doctorPhone;
    // 科室名称
    private String officesName;
    // 医生照片
    private String doctorImg;
    // 医生职称
    private String doctorTitle;
    // 医生特长
    private String doctorForte;
    // 医生关于
    private String doctorAbout;
    //最大预约人数
    private Integer max;
}
