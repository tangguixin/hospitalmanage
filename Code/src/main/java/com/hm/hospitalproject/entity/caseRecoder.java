package com.hm.hospitalproject.entity;

import java.util.Date;

public class CaseRecoder {
    private Integer caseId;

    private Date creatTime;

    private Integer doctorId;

    private String jiazhushi;

    private Integer patientsId;

    private String xianbingshi;

    private String zhusu;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getJiazhushi() {
        return jiazhushi;
    }

    public void setJiazhushi(String jiazhushi) {
        this.jiazhushi = jiazhushi == null ? null : jiazhushi.trim();
    }

    public Integer getPatientsId() {
        return patientsId;
    }

    public void setPatientsId(Integer patientsId) {
        this.patientsId = patientsId;
    }

    public String getXianbingshi() {
        return xianbingshi;
    }

    public void setXianbingshi(String xianbingshi) {
        this.xianbingshi = xianbingshi == null ? null : xianbingshi.trim();
    }

    public String getZhusu() {
        return zhusu;
    }

    public void setZhusu(String zhusu) {
        this.zhusu = zhusu == null ? null : zhusu.trim();
    }
}