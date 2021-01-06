package com.hm.hospitalproject.entity;

import java.util.Date;

//检查项
public class CheckIterm {
    private Integer id;

    private Integer checkId;

    private String doctorName;

    private Date gmtCreate;

    private Boolean jiesuan;

    private Integer patientId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Boolean getJiesuan() {
        return jiesuan;
    }

    public void setJiesuan(Boolean jiesuan) {
        this.jiesuan = jiesuan;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
}