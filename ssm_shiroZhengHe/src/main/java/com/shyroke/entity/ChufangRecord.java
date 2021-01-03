package com.shyroke.entity;

import java.util.Date;

public class ChufangRecord {
    private Integer id;

    private Integer patientId;

    private Integer doctorId;

    private String bingqing;

    private String chufang;

    private String beizhu;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getBingqing() {
        return bingqing;
    }

    public void setBingqing(String bingqing) {
        this.bingqing = bingqing;
    }

    public String getChufang() {
        return chufang;
    }

    public void setChufang(String chufang) {
        this.chufang = chufang;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

	@Override
	public String toString() {
		return "ChufangRecord [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", bingqing="
				+ bingqing + ", chufang=" + chufang + ", beizhu=" + beizhu + ", time=" + time + "]";
	}
    
    
    
}